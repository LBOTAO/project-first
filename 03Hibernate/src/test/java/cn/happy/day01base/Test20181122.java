package cn.happy.day01base;

import cn.happy.day01base.entity.Customer;
import cn.happy.day01base.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 9:51
 */
public class Test20181122 {
    //一级缓存对增删改的测试  测试结果 无影响
    @Test
    public void createCacheTest(){
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("==================================");
        Customer customer2 = session.get(Customer.class, 2L);
        System.out.println(customer2.getCustName());
        System.out.println("============================");
        Customer customer=new Customer();
        customer.setCustName("刘宇宁");
        session.save(customer);
        System.out.println("=============");
        Customer customer3 = session.get(Customer.class, 2L);
        System.out.println(customer3.getCustName());
        tx.commit();
        session.close();  //session关闭一级缓存消失
    }
    //证明一级缓存的存在
    @Test
    public void cacheTest(){
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 2L);
        System.out.println(customer.getCustName());
        System.out.println("==================================");
        Customer customer2 = session.get(Customer.class, 2L);
        System.out.println(customer2.getCustName());
        tx.commit();
        session.close();  //session关闭一级缓存消失
    }
}
