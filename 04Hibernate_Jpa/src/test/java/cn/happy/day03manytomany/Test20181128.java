package cn.happy.day03manytomany;

import cn.happy.day01jpa.utils.JpaUtil;
import cn.happy.day03manytomany.entity.SysRole;
import cn.happy.day03manytomany.entity.SysUser;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * author：  刘涛
 *
 * @create 2018-11-28 15:08
 */
public class Test20181128 {
    @Test
    public void test4(){
        EntityManager em = JpaUtil.createEntityManager();
        EntityManager em2 = JpaUtil.createEntityManager();
        System.out.println(em==em2);
    }


    @Test
    public void test3(){
        EntityManager em = JpaUtil.createEntityManager();
        Session session = em.unwrap(Session.class);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println(connection
                .getClass().getName());
            }
        });
    }

    /**
     * 删除操作
     * 	在多对多的删除时，双向级联删除根本不能配置
     * 禁用
     *	如果配了的话，如果数据之间有相互引用关系，可能会清空所有数据
     */
    @Test
    public void test2(){
        //获取JPA操作对照
        EntityManager em = JpaUtil.createEntityManager();
        //获取JPA事务对象
        EntityTransaction tx= em.getTransaction();
        //开启事务
        tx.begin();
        SysUser u1 = em.find(SysUser.class,"4028b98167592e670167592e6f320000");
        em.remove(u1);
        tx.commit();
    }

    /**
     * 需求：
     * 	保存用户和角色
     * 要求：
     * 	创建2个用户和3个角色
     * 	让1号用户具有1号和2号角色(双向的)
     * 	让2号用户具有2号和3号角色(双向的)
     *  保存用户和角色
     */
    @Test
    public void test1(){
        //创建对象
        SysUser u1 = new SysUser();
        u1.setUserName("用户1");
        SysUser u2 = new SysUser();
        u2.setUserName("用户2");

        SysRole r1 = new SysRole();
        r1.setRoleName("角色1");
        SysRole r2 = new SysRole();
        r2.setRoleName("角色2");
        SysRole r3 = new SysRole();
        r3.setRoleName("角色3");

        //建立关联关系
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        r1.getUsers().add(u1);
        r2.getUsers().add(u1);

        u2.getRoles().add(r2);
        u2.getRoles().add(r3);
        r2.getUsers().add(u2);
        r3.getUsers().add(u2);

        //获取JPA操作对照
        EntityManager em = JpaUtil.createEntityManager();
        //获取JPA事务对象
        EntityTransaction tx= em.getTransaction();
        //开启事务
        tx.begin();
        em.persist(u1);
        tx.commit();
    }

}
