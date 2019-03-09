package cn.happy.day03mapping.manytomany;

import cn.happy.day01base.util.HibernateUtil;
import cn.happy.day02mapping.manytomany.entity.SysRole;
import cn.happy.day02mapping.manytomany.entity.SysUser;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * author：  刘涛
 *
 * @create 2018-11-27 16:34
 */
public class Test20181127 {

    /**
     * 需求：
     * 	保存用户和角色
     * 要求：
     * 	创建2个用户和3个角色
     * 	让1号用户具有1号和2号角色(双向的)
     * 	让2号用户具有2号和3号角色(双向的)
     *  保存用户和角色
     * 问题：
     *  在保存时，会出现主键重复的错误，因为都是要往中间表中保存数据造成的。
     * 解决办法：
     * 	让任意一方放弃维护关联关系的权利
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

        Session s = HibernateUtil.getCurentSession();
        Transaction tx = s.beginTransaction();
        s.save(u1);
        tx.commit();
    }

}
