package cn.mybatis.test;

import cn.mybatis.day02.dao.ICategoryDao;
import cn.mybatis.day02.dao.IEmpBakDao;
import cn.mybatis.day02.dao.IStudentDao;
import cn.mybatis.day02.entity.*;
import cn.mybatis.day01base.util.MyBatisUtil;
import cn.mybatis.day02.dao.IDeptDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-08 14:53
 */
public class Test20181108 {
    /**
     *
     * @throws IOException
     */
    @Test
    public void testCache() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpBakDao mapper = session.getMapper(IEmpBakDao.class);
        EmpBak empbak = mapper.getEmpByDeptNoMultiSql(3);
        System.out.println(empbak.getEmpnames());
        System.out.println(empbak.getDept().getDeptname());
        System.out.println("===============================");
        EmpBak empbak2 = mapper.getEmpByDeptNoMultiSql(3);
        System.out.println(empbak2.getEmpnames());
        System.out.println(empbak2.getDept().getDeptname());
    }

    //测试延迟加载
    @Test
    public void testLazy() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpBakDao mapper = session.getMapper(IEmpBakDao.class);
        EmpBak empbak = mapper.getEmpByDeptNoMultiSql(3);
        System.out.println(empbak.getEmpnames());
        System.out.println(empbak.getDept().getDeptname());
    }

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

    //自关联
    @Test
    public void getChildrenListByPid() throws IOException {
            SqlSession session=MyBatisUtil.getSession();
            ICategoryDao mapper=session.getMapper(ICategoryDao.class);
            List<Category> list = mapper.getChildrenListByPid(1);
            for (Category cate:list){
                System.out.println(cate);
            }
            session.close();
    }

    //自关联2
    @Test
    public void getCategoryByPid() throws Exception {
        SqlSession session=MyBatisUtil.getSession();
        ICategoryDao mapper=session.getMapper(ICategoryDao.class);
        List<Category> list = mapper.getCategoriesByCid(9);
        for (Category cate:list){
            System.out.println(cate.getPid());
            System.out.println(cate);
        }
        session.close();
    }

    @Test
    public void getManyToMany() throws Exception {
        SqlSession session=MyBatisUtil.getSession();
        IStudentDao mapper=session.getMapper(IStudentDao.class);
        List<Teacher> list = mapper.findTeacherBySid(2);
        for (Teacher cate:list){
            System.out.println(cate.getTname());
        }
        session.close();
    }
}
