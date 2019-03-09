package cn.happy.day03mapping.onetomany;

import cn.happy.day01base.util.HibernateUtil;
import cn.happy.day02mapping.onetomany.entity.Customer;
import cn.happy.day02mapping.onetomany.entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * author：  刘涛
 *
 *  对象导航查询
 *
 * @create 2018-11-27 15:02
 */
public class Test20181127 {
    /**
     * 将load方法的延迟加载 改为立即加载   在所查询对应的映射文件的class标签中设置lazy属性
     */
    @Test
    public void test2(){
        Session session = HibernateUtil.getCurentSession();
        Transaction tx = session.beginTransaction();
        LinkMan linkMan = session.load(LinkMan.class, 1L);
        System.out.println(linkMan);
        tx.commit();
    }

    /**
     * 需求：
     * 	查询ID为1的联系人所属客户
     *
     * 	我们查询联系人时    要不要把客户查询出来
     *
     * 	使用延迟加载：
     * 	在LinkMan.hbm.xml配置文件中的many-to-one标签上使用lazy属性。取值为proxy|fasle
     false:立即加载
     proxy：看客户的映射文件class标签的lazy属性取值，如果客户的class标签lazy属性是true
     那么proxy表示延迟加载，如果是false就表示立即加载。

     */
    @Test
    public void test3(){
        Session s = HibernateUtil.getCurentSession();
        Transaction tx = s.beginTransaction();
        LinkMan l = s.get(LinkMan.class, 2L);
        System.out.println(l.getCustomer());
        tx.commit();
    }

    /**
     * 需求：
     * 	查询ID为的1客户有多少联系人
     * 	我们在查询 客户时 不希望查询联系人的信息
     * 	 解决方案  ：： 使用延迟加载
     * 	  在Customer.hbm.xml配置文件中的set标签上使用lazy属性。取值为true（默认值）|fasle
     *
     */
    @Test
    public void test1(){
        Session s = HibernateUtil.getCurentSession();
        Transaction tx = s.beginTransaction();
        Customer c = s.get(Customer.class, 1L);
        Set<LinkMan> linkmans = c.getLinkmans();//此处就是对象导航查询
        for(Object o : linkmans){
            System.out.println(o);
        }
        tx.commit();
    }

}
