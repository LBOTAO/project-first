package cn.happy.day01base;

import cn.happy.day01base.entity.Customer;
import cn.happy.day01base.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 22:30
 */
public class Test20181120 {
    /**
     * merge（）  有id  做修改操作   没有id做save操作
     */
    @Test
    public void testMerge(){
        Session session = HibernateUtil.openSession();
        Transaction tx=session.beginTransaction();
        Customer c1 = session.get(Customer.class, 2L);
        c1.setCustAddress("北京市海淀区五道口");
        tx.commit();
        session.close();  //关闭
        Session session1 = HibernateUtil.openSession();
        Transaction tx2 = session1.beginTransaction();
        Customer c2 = session1.get(Customer.class, 2L);
        session1.merge(c1);
        tx2.commit();
        session1.close();
    }


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
    @Test
    public void testGet(){
        Session session = HibernateUtil.openSession();
        //Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 2L);
        System.out.println(customer);
        //事务提交和释放资源
       // tx.commit();
        session.close();
    }

    @Test
    public void testLoad(){
        Session session = HibernateUtil.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.load(Customer.class, 2L);
        System.out.println(customer);
        //事务提交和释放资源
        tx.commit();
        session.close();
    }
    /**
     * 添加客户
     */
    @Test
    public void test01(){
        //解析主配置文件
        Configuration cfg=new Configuration();  //创建xml文件
        cfg.configure();  //加载主配置文件   在类路径下默认的名称的配置文件名称
        /*关联小配置文件*/
        //cfg.addResource("cn/happy/day01base/entity/Customer.hbm.xml");
        //cfg.addClass(Customer.class);  //映射配置文件名必须一致
        //通过解析主配置文件构建并获的session工厂
        SessionFactory factory = cfg.buildSessionFactory();
        //获取session
        Session session = factory.openSession();

        Customer customer=new Customer();
        customer.setCustName("杨树林");
        Transaction transaction = session.beginTransaction();
        //执行操作
        session.save(customer);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        factory.close();

    }

    /**
     * 添加
     */
    @Test
    public void testAdd(){
        Session session = HibernateUtil.openSession();
        Customer customer=new Customer();
        customer.setCustName("汪苏泷");
        //开启事务  增删改  都需要运行在事务中
        Transaction tx = session.beginTransaction();
        session.save(customer);
        //事务提交和释放资源
        tx.commit();
        session.close();
    }

    /**
     * 按照id查询用户
     */
    @Test
    public void testFindOne(){
        Session session = HibernateUtil.openSession();
        //开启事务  增删改  都需要运行在事务中
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 2L);
        System.out.println(customer);
        //事务提交和释放资源
        tx.commit();
        session.close();
    }

    /**
     * 修改用户
     */
    @Test
    public void testUpdate(){
        Session session = HibernateUtil.openSession();
        //开启事务  增删改  都需要运行在事务中
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 2L);
        customer.setCustAddress("北京海淀区");
        session.update(customer);
        //事务提交和释放资源
        tx.commit();
        session.close();
    }

    /**
     * 删除用户
     */
    @Test
    public void testdelete(){
        Session session = HibernateUtil.openSession();
        //开启事务  增删改  都需要运行在事务中
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 3L);
        session.delete(customer);
        //事务提交和释放资源
        tx.commit();
        session.close();
    }

    /**
     * 查询全部
     */
    @Test
    public void testFindAll(){
        Session session = HibernateUtil.openSession();
        //开启事务  增删改  都需要运行在事务中
        Transaction tx = session.beginTransaction();
        //通过session获得查询对象query
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM cst_customer");
        List<Object[]> list = sqlQuery.list();
        for (Object[] ob:list){
            System.out.println("数组中的内容-----");
            for (Object o:ob){
                System.out.println(o);
            }
        }
        //事务提交和释放资源
        tx.commit();
        session.close();
    }

    /**
     * 测试连接池是否配置成功
     */
    @Test
    public void testC3P0(){
        Session session = HibernateUtil.openSession();
        //开启事务  增删改  都需要运行在事务中
        Transaction tx = session.beginTransaction();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println(connection.getClass().getName());
            }
        });
        //事务提交和释放资源
        tx.commit();
        session.close();
    }
}
