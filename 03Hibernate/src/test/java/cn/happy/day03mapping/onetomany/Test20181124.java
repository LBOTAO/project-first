package cn.happy.day03mapping.onetomany;

import cn.happy.day01base.util.HibernateUtil;
import cn.happy.day02mapping.onetomany.entity.Customer;
import cn.happy.day02mapping.onetomany.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * author：  刘涛
 *  一对多关联映射  crud
 * @create 2018-11-24 9:48
 */
public class Test20181124 {


    /**
     * 删除操作
     * 		删除从表数据就是单表
     * 		删除主表数据：
     * 			看有没有从表数据引用
     * 				有引用：
     * 					在删除是，hibernate会把从表中的外键字段置为null，然后再删除主表数据。
     * 					如果外键字段有非空约束，则hibernate不能更新外键字段为null，会报错。
     * 					如果仍然想删除，此时需要使用级联删除。同时必须配置inverse属性是true。
     * 				没有引用： 就是单表，直接删
     */
    @Test
    public void test5(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 3L);
        session.delete(customer);
        tx.commit();
    }



    @Test
    /**
     * 更新操作
     * 	需求：
     * 	  创建一个新的联系人，查询一个已有客户
     * 	 联系人新联系人和已有客户的双向关联关系
     * 	更新客户
     */
    public void test4(){
        Session s = HibernateUtil.getCurentSession();
        Transaction tx = s.beginTransaction();
        //1.查询一个客户
        Customer c1 = s.get(Customer.class, 1L);
        //2.创建一个新的联系人
        LinkMan l = new LinkMan();//瞬时态
        l.setLkmName("一对多的联系人");
        //3.建立客户和联系人的关联关系（双向）
        l.setCustomer(c1);
        c1.getLinkmans().add(l);
        //4.更新客户
        s.update(c1);
        tx.commit();
    }

    @Test
    /**
     * 保存操作：
     * 		级联保存
     *  使用级联保存，配置的方式，仍然是找到Customer的映射配置文件的Set标签，
     *  也可以配置在many-to-one上。
     *  在上面加入cascade属性
     *  	cascade：配置级联操作
     *  		级联保存更新的取值：save-update
     */
    public void test2(){
        Customer customer=new Customer();
        customer.setCustName("京张铁路集团1");
        LinkMan linkMan=new LinkMan();
        linkMan.setLkmName("金瀚1");
        linkMan.setCustomer(customer);
        customer.getLinkmans().add(linkMan);
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
    }



    @Test
    //添加新联系人 绑定客户
    public void test1(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        Customer c = session.get(Customer.class, 2L);
        LinkMan linkMan=new LinkMan();
        linkMan.setLkmName("金瀚");
        linkMan.setCustomer(c);
        session.save(linkMan);
        tx.commit();
    }
}