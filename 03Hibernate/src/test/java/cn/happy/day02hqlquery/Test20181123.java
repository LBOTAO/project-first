package cn.happy.day02hqlquery;

import cn.happy.day01base.entity.Customer;
import cn.happy.day01base.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * author：  刘涛
 *    hibernate中的hql查询
 * @create 2018-11-23 15:04
 */
public class Test20181123 {
    /**
     * hibernate中的五种
     * oid
     *   根据id查询一个实体
     *   get
     *   load方法
     *
     * sql查询
     *  hql
     *  qbc
     *  对象导航查询
     */

    //基本查询
    @Test
    public void testFindAll(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx=session.beginTransaction();
        //得到query对象
        Query query = session.createQuery("from Customer");  //查询全部
        //获取结果集
        List<Customer> customer = query.list();
        for (Customer item:customer){
            System.out.println(item.getCustName());
        }
        tx.commit();
    }

    //条件查询  有缺陷
    @Test
    public void testfindByLike(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx=session.beginTransaction();
        //得到query对象
        Query query = session.createQuery("from Customer where custLevel=? and custName like ?");  //查询全部
        query.setString(0,"23");  //给参数占位符赋值
        query.setString(1,"%京%");
        //获取结果集
        List<Customer> customer = query.list();
        for (Customer item:customer){
            System.out.println(item.getCustName());
        }
        tx.commit();
    }

    //给参数占位符提供一个具体的名称
    @Test
    public void testfindByLike2(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx=session.beginTransaction();
        //得到query对象
        Query query = session.createQuery("from Customer where custLevel=:custLevel and custName like :custName");  //查询全部
       /* query.setString("custLevel","23");  //给参数占位符赋值
        query.setString("custName","%京%");*/
       query.setParameter("custLevel","23");
       query.setParameter("custName","%京%");
        //获取结果集
        List<Customer> customer = query.list();
        for (Customer item:customer){
            System.out.println(item.getCustName());
        }
        tx.commit();
    }


    //分页查询
    @Test
    public void testfindByLimit(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx=session.beginTransaction();
        //得到query对象
        Query query = session.createQuery("from Customer");  //查询全部
        query.setFirstResult(0);
        query.setMaxResults(2);
        //获取结果集
        List<Customer> customer = query.list();
        for (Customer item:customer){
            System.out.println(item.getCustName());
        }
        tx.commit();
    }


    //排序查询
    @Test
    public void testfindByshort(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx=session.beginTransaction();
        //得到query对象
        Query query = session.createQuery("from Customer order by custId desc");  //查询全部
        //获取结果集
        List<Customer> customer = query.list();
        for (Customer item:customer){
            System.out.println(item.getCustName());
        }
        tx.commit();
    }

    //统计查询
    @Test
    public void testfindBycount(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx=session.beginTransaction();
        //得到query对象
        Query query = session.createQuery("select count(*) from Customer");  //查询全部
        //获取结果集
        Long o =(Long)query.uniqueResult();   //返回结果只有一条时使用 如果返回多条  会抛出异常
        System.out.println(o);
        tx.commit();
    }

    //投影查询

    /**
     * 投影查询：
     * 	 投影：使用一个实体的部分字段信息，来构建实体类对象，叫做对象的投影（在hibernate中的叫法）
     * 	使用HQL的方式查询实体类的部分字段信息，并且封装到实体类中。(QBC也能实现投影查询，但是不如hql的好用，所以使用投影查询，一般都用HQL)
     * HQL语句的写法：
     * 	 select  new Customer() from Customer
     * 	 如果工程只有一个唯一的类，可以不写全限定类名，否则必须写全限定类名。
     * 实体类要求：
     * 	必须提供一个相同参数列表的构造函数
     */

    @Test
    public void testfind(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx=session.beginTransaction();
        //得到query对象
        Query query = session.createQuery("select new cn.happy.day01base.entity.Customer(custId,custName) from Customer");  //查询全部
        //获取结果集
        List o = query.list();
        for (Object item:o){
            System.out.println(item);
        }
        tx.commit();
    }


}
