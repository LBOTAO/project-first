package cn.happy.day02hqlquery;

import cn.happy.day01base.entity.Customer;
import cn.happy.day01base.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

/**
 * author：  刘涛
 * QBC
 *   QBC(Query By Criteria) API提供了检索对象的另一种方式，
 *   它主要由Criteria接口、Criterion接口和Expresson类组成，它支持在运行时动态生成查询语句。
 * @create 2018-11-23 16:13
 */
public class Test20181123_2 {



    //查询全部
    @Test
    public void test1(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        List list = criteria.list();
        for (Object o:list){
            System.out.println(o);
        }
        tx.commit();
    }

    //条件查询
    @Test
    public void test2(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);  //它就相当于HQL的from Customer
        criteria.add(Restrictions.lt("custLevel","23"));
        List list = criteria.list();
        for (Object o:list){
            System.out.println(o);
        }
        tx.commit();
    }



    //分页查询  与hql查询一致
    @Test
    public void test3(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);  //它就相当于HQL的from Customer
        criteria.setFirstResult(0);
        criteria.setMaxResults(3);
        List list = criteria.list();
        for (Object o:list){
            System.out.println(o);
        }
        tx.commit();
    }


    //排序查询
    @Test
    public void test4(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);  //它就相当于HQL的from Customer
        criteria.addOrder(Order.desc("custId"));
        List list = criteria.list();
        for (Object o:list){
            System.out.println(o);
        }
        tx.commit();
    }

    //聚合函数的使用
    @Test
    public void test5(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);  //它就相当于HQL的from Customer
        criteria.setProjection(Projections.min("custLevel"));
        Object o =criteria.uniqueResult();
        System.out.println(o);
        tx.commit();
    }



    /**
     * 离线条件查询
     * 	离线：
     * 		它是和在线对应的。
     * 		Criteria对象是一个在线对象，它是由一个可用的（活动的）Session对象获取的出来的。
     * 		当session失效时，就无法再获取该对象了。
     *  有一个对象，它也可以用于设置条件，但是获取的时候并不需要Session对象。
     *  该对象就叫做离线对象：
     *  		DetachedCriteria对象
     *  使用该对象进行的查询就叫做：离线查询
     *
     *  如何获取该对象
     * 		DetachedCriteria dCriteria = DetachedCriteria.forClass(要查询的实体类字节码);
     *
     */
    //离线查询
    @Test
    public void testServlet(){
        //1.获取离线对象，不需要Session
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        //2.封装查询条件
        dc.add(Restrictions.eq("custLevel", "23"));
        dc.add(Restrictions.like("custName","%集%"));

        List list = testService(dc);
        for(Object o : list){
            System.out.println(o);
        }
    }

    private List testService(DetachedCriteria dc) {
        Session s = null;
        Transaction tx  = null;
        try{
            s = HibernateUtil.getCurentSession();
            tx = s.beginTransaction();
            List list = testDao(dc);
            tx.commit();
            return list;
        }catch(Exception e){
            tx.rollback();
        }
        return null;

    }

    private List testDao(DetachedCriteria dc) {
        Session s = HibernateUtil.getCurentSession();
        //把离线对象转成在线对象
        Criteria c = dc.getExecutableCriteria(s);

        return  c.list();
    }





}
