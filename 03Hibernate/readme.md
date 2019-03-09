2018年11月22日09:38:44

oid  object  identity  对象标识符
hibernate   主键生成策略  六种
    sequence
    increment
    native
    assige
    uuid
    identity


代理主键
  代理主键是只区分数据库记录的   不会参与程序中的 业务逻辑

自然主键
不仅用于区分数据库记录  而且还参与程序中的业务逻辑  必须支付功能的订单号不仅需要添加到数据库保持唯一性
 而且会将此订单号传入到集成的一些个支付软件  比如支付宝

hibernate的缓存

缓存 ：
  什么是缓存？
  内存中的临时数据。

  缓存存在哪？存的是什么
  内存，  数据

  缓存的作用？
  不用缓存可以吗  可以的
  缓存的作用就是将  减少和数据库交互的次数，从而提高效率

  适用缓存的数据？
    经常查询的 并且不经常修改的，，安全性较低的。 数据出现问题  对最终结果影响不大的 。

  不适用缓存：
  经常修改的  不能使用  比如  商品库存、  银行的汇率


hibernate中的快照  ：
快照存储的数据就是从 数据库中查询出的  
》快照是数据的副本
》快照属于一级缓存
》保证数据的一致性
》属于堆内存


当执行session.getTransaction().commit() 是hibernate会杀心一级缓存  也就是将一级缓存中的数据和快照中的数据进行对比  如果数据不一致则
update，一致，不执行update






一级缓存：


二级缓存

2018年11月23日13:55:49------
hibernate 对象的状态 ：
 瞬时状态(临时状态)  ：new 出來的属于瞬时  标志  ：  没有oid ，和session没有关系
 持久状态：   保存  save() 有oid   和session有关系
 托管状态（游离状态）：脱离session管理  有oid和session没有关系。



保存时多一条update语句  的问题解决

在映射配置文件的  set标签中设置inverse属性。
      inverse的默认值是false，代表不放弃外键维护权，配置值为true，代表放弃了外键的维护权。代码如下

      解决多一条update语句的问题：
      ```java
       <set name="linkmans" table="cst_linkman" inverse="true">
            		<key column="lkm_cust_id"></key>
            		<one-to-many class="LinkMan"/>
            </set>
      ```


级联保存和修改：
    ```java
    cascade="save-update"
    ```
    
lazy属性  解析：
 
延迟加载：
Hibernate是如何延迟加载的
（1）首先介绍一下延迟加载的几种情况：
       当调用Session上的load（）方法加载实体时，就会采用延迟加载
       当Session加载某个实体时，会对这个实体中的集合属性值采用延迟加载
   当Session加载某个实体时，会对这个实体所单端关联（one-to-one，many-to-one）的另一个实体对象采用延迟加载
      总结一句话延迟加载就是分为类的延迟加载和集合的延迟加载，即类的延迟加载包括用load（）方法加载实体和
       加载实体所单向关联的另一个实体的对象

（2）延迟加载的过程：
       Hibernate从数据库获取某一个对象数据、获取某一个对象的集合属性时，获取某一个对象所关联的另一个对象时，
       由于没有使用该对象的数据，hibernate并不从数据库加载真正的数据。而是为该对象创建一个代理对象来代表这个对象，
       这个对象上的所有属性都为默认值，只有在真正的需要该对象的数据时才创建这个真实的对象，真正的从数据库中加载数据。
       注：如果访问的是对象标识符属性，没有必要初始化代理
(3)延迟加载的使用
     因为在类加载和集合加载的时候都会遇到懒加载的问题，当我们在查询的时候不需要懒加载，
     因为通过懒加载不能查到是情况下，可以在class类标签或者是set集合的标签中设置lazy=false，表示立即加载，而true表示懒加载
 
  

实现多对多：需要借助中间表
  两方都是一对多  就是多对多   
  
什么是联合主键
： 联合主键就是用2个或2个以上的字段组成主键。

load方法和get方法的区别??
    /**
     * get方法和load方法的区别
     *
     * 01查询的时机不一样
     * get立即加载
     * load是延迟加载 又称为懒加载
     *
     *
     * 02.返回的结果也不一样
     * get返回的是实体对象
     * load返回的是实体对象的代理对象
     */
     
     
merge的作用是：新new一个对象，如果该对象设置了ID，则这个对象就当作游离态处理：

                                      当ID在数据库中不能找到时，用update的话肯定会报异常，然而用merge的话，就会insert。

                                      当ID在数据库中能找到的时候，update与merge的执行效果都是更新数据，发出update语句；

                              如果没有设置ID的话，则这个对象就当作瞬态处理：

                               用update的话，由于没有ID，所以会报异常，merge此时则会保存数据，根据ID生产策略生成一条数据；
```text
Session session1 = HibernateUtils.getSession();
Transaction transaction1 = session1.beginTransaction();
Students str1 = new Students();
str1.setStu_id(4);
str1.setName("222");
session1.merge(str1);
str1.setName("333");
transaction1.commit();
session1.clear();
session1.close();
```

下面是当对象在第一个session关闭后，处于游离状态，第二个session开启，又get或load一样的ID的数据出来时，在第二个session中update那个游离态对象，

          update肯定会出错，原因是程序会报持久层中已经有该对象，因为第二个session重新从数据库中获取了一个对象成持久态，你的update会让那个游离态对象也变成持久态，两个持久态会冲突撒，然而用merge的话，它会把第一个的对象数据赋值给已经处于持久化的那个对象中，自己本身不得变为持久态；（这个我测试很多到的，没问题）

```text
Session session1 = HibernateUtils.getSession();

Transaction transaction1 = session1.beginTransaction();

Students str1 = (Students)session1.get(Students.class, 2);
transaction1.commit();
session1.clear();
session1.close();

Session session2 = HibernateUtils.getSession();
Transaction transaction2 = session2.beginTransaction();
Students str2 = (Students)session2.get(Students.class, 2);
session2.merge(str1);
transaction2.commit();
session2.clear();
session2.close();



Session session2 = HibernateUtils.getSession();
Transaction transaction2 = session2.beginTransaction();
Students str2 = (Students)session2.get(Students.class, 2);
str1.setName("wer");
session2.merge(str1);
System.out.println(str2.getName());  //这里改变了，说明持久态的数据也会改变
str2.setName("ee");
System.out.println(str1.getName());   //这里不会改变，说明第一个游离态的数据没有被持久化撒；
transaction2.commit();
session2.clear();
session2.close();```