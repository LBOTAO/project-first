#day01-----
程序间的依赖关系：
    程序间依赖一定遵守编译期不依赖  运行期依赖
 解决程序间的依赖关系：
     反射  Class.forName("com.jdbc.mysql");
 反射创建类对象引发的问题：
     通过配置文件来反射创建类对象

什么是控制反转 inversion  of  control  ioc
   ”反转“  可以理解成本来我们需要new创建对象   现在反转了  spring容器帮我们创建 把控制权交给spring容器
   不用我们主动new,而是我们需要的时候
   去spring容器中索取所需要的对象实例。


 Bean的两种创建方式：
   BeanFactory   延迟加载创建方式
   ApplicationContext   立即加载创建方式

 Bean的三种创建方式:
   第一种：使用默认无参构造函数
   第二种： 使用静态工厂
   第三种：使用实例工厂


spring依赖注入  ：
  三种  ：set方法注入
         构造注入
         p命名空间 注入  本质上还是set方法注入


bean  ：---》》autowire:

   byType: 按照对象的类型进行注入  如果多个类型匹配 就会报错     使用要注入对象的变量名作为bean的id
   byName:直接按照bean的id注入   bean的id和实体类中的属性名匹配


集合注入：---   array list set  map  properties

aop的专业术语：
1. 通知： 就是我们编写的希望Aop时执行的那个方法。我们通过Aop希望我们编写的方法在目标方法执行前执行，或者执行后执行。
2. 切点：
  符合咱们的切点表达式的方法
切点就是我们我们配置的满足我们条件的目标方法。比如我们规定：名字前面是select开头的才执行我们自定义的通知方法。
那么这些select开头的方法就是切点。

3. 连接点：连接点可以说是切点的全集。切点是连接点的子集。也可以理解为，连接点是我们没有定义那个select开头规则时，满足条件的全部的方法。

4. 切面：切面是切点和通知（增强）的组合称谓，就是变相给组合起了个名字。

5.目标对象：

6.织入：增强和切点 进行运行时动态绑定的过程叫织入

7.代理对象：  一个类被AOP织入后生成出了一个结果类，它是融合了原类和增强逻辑的代理类。



#---2018年11月20日14:41:50----------------------------------------
spring 中  bean 默认是单例的
变成单例的方法：  <bean id="" class="" scope="prototype"></bean>

---
在spring当中  进行域属性注入有两种手段：
     01.@Resource
     02.@AutoWired  结合  @Qualifier使用

  @Resource    默认按照byName名称  进行装配
   （
    拥有该注解的字段名称必须和spring容器现有名称的bean的id相同，

  @Resource比较智能  当根据byname方式装配方式失败以后，它会接着尝试bytype的方式。
  只要容器中有类型相同的bean也会自动装配
  ）


  @AutoWired   默认按照byType类型装配
  拥有该字段的注解类型    （必须跟现有spring容器中的bean的类型相同  ：
    如果发现有相同多个类型的bean   会抛出异常）

 @Qualifier  （将此注解和@Autowired注解混合使用时  强制使用byName方式进行装配  不符合装配失败）

 代理

jdk动态代理   ： 面向接口进行代理
cglib动态代理 ：   面向类进行代理

#2018年11月22日17:19:13-----------------------------------------
顾问： 也就是通知（增强）  只不过我们将它包装升级了。。如果不使用会将目标方法中的所有方法进行增强。
顾问也就像aspactj中的切点表达式  可以过滤掉某些  不想增强  的方法

2018年11月24日14:26:40===
顾问中  无论方法匹配切入点顾问   还是正则匹配切入点顾问   都扫描的是全类名中的内容 --------------------------注意

```
自动代理：   org.springframework.aop.support.RegexpMethodPointcutAdvisor  ：只对顾问。。。。。

          org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator  顾问  和增强  都可以
```

 Spring之AOP报错：Null return value from advice does not match primitive return type for================

 解决方案：：： aop报错应该是在CglibAopProxy的这段代码,测试了一下改成int的包装类型Integer就好了。



 切点表达式：==============================

 Aspectj切入点语法定义

 在使用spring框架配置AOP的时候，不管是通过XML配置文件还是注解的方式都需要定义pointcut"切入点"

 例如定义切入点表达式  execution (* com.sample.service.impl..*.*(..))

 execution()是最常用的切点函数，其语法如下所示：

  整个表达式可以分为五个部分：

  1、execution(): 表达式主体。

  2、第一个*号：表示返回类型，*号表示所有的类型。

  3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。

  4、第二个*号：表示类名，*号表示所有的类。

  5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。


AspectJ的Execution表达式

execution()

execution()是最常用的切点函数，其语法如下所示：

execution(<修饰符模式>? <返回类型模式> <方法名模式>(<参数模式>) <异常模式>?)  除了返回类型模式、方法名模式和参数模式外，其它项都是可选的。与其直接讲解该方法的使用规则，还不如通过一个个具体的例子进行理解。下面，我们给出各种使用execution()函数实例。


#2018年11月27日13:05:26
  对于jdbcTempleate的整合
