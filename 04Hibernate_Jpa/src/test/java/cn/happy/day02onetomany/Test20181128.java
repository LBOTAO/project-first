package cn.happy.day02onetomany;

import cn.happy.day01jpa.utils.JpaUtil;
import cn.happy.day02onetomany.entity.Customer;
import cn.happy.day02onetomany.entity.LinkMan;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Set;

/**
 * author：  刘涛
 *
 * @create 2018-11-28 13:17
 */
public class Test20181128 {
    //；查询 查询联系人id为2下的客户是谁
    @Test
    public void test05(){
        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        LinkMan linkMan = em.find(LinkMan.class, 2L);
        System.out.println(linkMan);
        Customer customer = linkMan.getCustomer();
        System.out.println(customer);
        tx.commit();
        em.close();
    }

    //；查询 查询客户id为2下的联系人有哪些
    @Test
    public void test04(){
        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class, 2L);
        System.out.println(customer);
        Set<LinkMan> linkMen = customer.getLinkMen();
        System.out.println(linkMen);
        tx.commit();
        em.close();
    }


    //删除
    @Test
    public void test03(){
        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class, 5L);
        em.remove(customer);
        tx.commit();
        em.close();
    }

    //更新
    @Test
    public void test02(){
        LinkMan linkMan=new LinkMan();
        linkMan.setLkmName("我是范冰冰的联系人");
        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class, 3L);
        customer.getLinkMen().add(linkMan);
        linkMan.setCustomer(customer);
        tx.commit();
        em.close();
    }

    //添加 客户  联系人进行关联
    @Test
    public void test01(){
        Customer customer=new Customer();
        customer.setCustName("呵呵");
        LinkMan linkMan=new LinkMan();
        linkMan.setLkmName("我是呵呵的联系人");
        customer.getLinkMen().add(linkMan);
        linkMan.setCustomer(customer);
        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        em.persist(linkMan);
        tx.commit();
        em.close();
    }
}
