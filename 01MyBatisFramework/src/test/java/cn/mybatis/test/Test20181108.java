package cn.mybatis.test;

import cn.mybatis.day02.dao.IEmpBakDao;
import cn.mybatis.day02.entity.EmpBak;
import cn.mybatis.day02.entity.UserInfo;
import cn.mybatis.day01base.util.MyBatisUtil;
import cn.mybatis.day02.dao.IDeptDao;
import cn.mybatis.day02.entity.Dept;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

/**
 * author：  刘涛
 *
 * @create 2018-11-08 14:53
 */
public class Test20181108 {

    //测试一对多单条sql
    @Test
    public void test() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        Dept dept = mapper.getUserByDeptNo(1);
        System.out.println(dept.getDeptname());

        for (UserInfo item:dept.getList()){
            System.out.println(item.getName());
        }
        MyBatisUtil.closeSession();
    }
    //测试一对多多条sql
    @Test
    public void testOnToManyMultiSql() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        Dept dept = mapper.getUserByDeptNoMultiSql(1);
        System.out.println(dept.getDeptname());

        for (UserInfo item:dept.getList()){
            System.out.println(item.getName());
        }
        MyBatisUtil.closeSession();
    }

    //测试多对一单条sql
    @Test
    public void testManyToOneSingleSql() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpBakDao mapper = session.getMapper(IEmpBakDao.class);
        EmpBak empBak = mapper.getEmpByDeptNo(2);
        System.out.println("员工："+empBak.getEmpnames()+"------"+empBak.getDept().getDeptname());

        MyBatisUtil.closeSession();
    }

    //测试多对一多条sql
    @Test
    public void testManyToOneMutilSql() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpBakDao mapper = session.getMapper(IEmpBakDao.class);
        EmpBak empbak = mapper.getEmpByDeptNoMultiSql(3);
        System.out.println(empbak.getEmpnames()+"=="+empbak.getDept().getDeptname());
    }
}
