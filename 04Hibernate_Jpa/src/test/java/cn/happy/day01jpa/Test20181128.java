package cn.happy.day01jpa;

import cn.happy.day01jpa.entity.Customer;
import cn.happy.day01jpa.utils.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * author：  刘涛
 *  jpa的curd操作
 * @create 2018-11-28 10:56
 */
public class Test20181128 {
    //延迟加载   getReferenc()
    //查询所有
    @Test
    public void test07(){
        //获取EntityManager对象
        EntityManager em = JpaUtil.createEntityManager();
        //创建事务对象  并开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //调用查询的方法
        Customer customer1 = em.getReference(Customer.class, 2L);
        System.out.println(customer1);
        tx.commit();
        em.close();
    }

    //查询所有
    @Test
    public void test06(){
        //获取EntityManager对象
        EntityManager em = JpaUtil.createEntityManager();
        //创建事务对象  并开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("select c from Customer c where custName like :custName");
       // query.setParameter(1,"%集%");
        query.setParameter("custName","%集%");
        List<Customer> list = query.getResultList();
        for (Customer customer :list){
            System.out.println(customer);
        }
        tx.commit();
        em.close();
    }

    //删除操作
    @Test
    public void test05(){
        //获取EntityManager对象
        EntityManager em = JpaUtil.createEntityManager();
        //创建事务对象  并开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //调用查询的方法
        Customer customer1 = em.find(Customer.class, 1L);
        em.remove(customer1);
        tx.commit();
        em.close();
    }

    //更新操作  merge（） 合并
    @Test
    public void test04(){
        //获取EntityManager对象
        EntityManager em = JpaUtil.createEntityManager();
        //创建事务对象  并开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //调用查询的方法
        Customer customer1 = em.find(Customer.class, 1L);
        customer1.setCustAddress("海淀区五道口");
        em.merge(customer1);
        tx.commit();
        em.close();
    }
    //更新操作  对象状态的转换实现更新
    @Test
    public void test03(){
        //获取EntityManager对象
        EntityManager entityManager = JpaUtil.createEntityManager();
        //创建事务对象  并开启事务
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        //调用查询的方法
        Customer customer1 = entityManager.find(Customer.class, 1L);
        customer1.setCustAddress("海淀区");
        tx.commit();
        entityManager.close();
    }

    //查询一个实体
    @Test
    public void test02(){
        //获取EntityManager对象
        EntityManager entityManager = JpaUtil.createEntityManager();
        //创建事务对象  并开启事务
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        //调用查询的方法
        Customer customer1 = entityManager.find(Customer.class, 1L);
        System.out.println(customer1);
        tx.commit();
        entityManager.close();
    }

    //添加
    @Test
    public void test01(){
        //创建客户对象并set值
        Customer customer=new Customer();
        customer.setCustName("金瀚");
        //获取EntityManager对象
        EntityManager entityManager = JpaUtil.createEntityManager();
        //创建事务对象  并开启事务
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        //调用添加的方法
        entityManager.persist(customer);
        tx.commit();
        entityManager.close();
    }

}
