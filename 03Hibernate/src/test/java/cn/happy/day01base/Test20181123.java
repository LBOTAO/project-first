package cn.happy.day01base;

import cn.happy.day01base.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * author：  刘涛
 *
 * @create 2018-11-23 14:57
 */
public class Test20181123 {
    //测试session与线程绑定
    @Test
    public void testCurrentThread(){
        Session s1 = HibernateUtil.getCurentSession();
        Session s2 = HibernateUtil.getCurentSession();
        System.out.println(s1==s2);
    }
}
