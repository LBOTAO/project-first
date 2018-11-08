package cn.mybatis.test;

import cn.mybatis.day01base.dao.IEmpDao;
import cn.mybatis.day01base.dao.IUserInfoDao;
import cn.mybatis.day01base.dao.impl.UserInfoDaoImpl;
import cn.mybatis.day01base.entity.ConditionModel;
import cn.mybatis.day01base.entity.Emp;
import cn.mybatis.day01base.entity.UserInfo;
import cn.mybatis.day01base.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-10-30 15:49
 */
public class Test20181030 {

    //动态sql  forech标签 自定义list
    @Test
    public void dynamicByForechListObjectTest() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpDao mapper = session.getMapper(IEmpDao.class);
        Emp emp1=new Emp();
        emp1.setId(1);
        Emp emp2=new Emp();
        emp2.setId(2);
        List<Emp> list=new ArrayList<>();
       list.add(emp1);
       list.add(emp2);
        List<Emp> emps = mapper.dynamicSqlForeachByListObject(list);
        for (Emp item:emps){
            System.out.println(item.getEmpnames());
        }
    }

    //动态sql  forech标签  list
    @Test
    public void dynamicByForechListTest() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpDao mapper = session.getMapper(IEmpDao.class);
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Emp> emps = mapper.dynamicSqlForeachByList(list);
        for (Emp item:emps){
            System.out.println(item.getEmpnames());
        }
    }

    //动态sql  forech标签  array
    @Test
    public void dynamicByForechTest() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpDao mapper = session.getMapper(IEmpDao.class);
        int[] ids={1,2,3};
        List<Emp> emps = mapper.dynamicSqlForeach(ids);
        for (Emp item:emps){
            System.out.println(item.getEmpnames());
        }
    }

    //动态sql  choose标签
    @Test
    public void dynamicByChooseTest() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpDao mapper = session.getMapper(IEmpDao.class);
        Emp emp=new Emp();
        //emp.setEmpnames("赫赫");
        //emp.setEmpphone("1963589756");
        List<Emp> emps = mapper.dynamicSqlByChoose(emp);
        for (Emp item:emps){
            System.out.println(item.getEmpnames());
        }
    }

    //动态sql  if标签
    @Test
    public void dynamicByIfTest() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IEmpDao mapper = session.getMapper(IEmpDao.class);
        Emp emp=new Emp();
       // emp.setEmpnames("赫赫");
        List<Emp> emps = mapper.dynamicSqlByIf(emp);
        for (Emp item:emps){
            System.out.println(item.getEmpnames());
        }
    }
    //多条件查询测试  参数为map
    @Test
    public void testMutilConditionByMap() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IUserInfoDao mapper = session.getMapper(IUserInfoDao.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","大乐");
        map.put("sex","男");
        List<UserInfo> userInfos = mapper.multiConditionByMap(map);
        for (UserInfo user:userInfos){
            System.out.println(user.getName());
        }
    }

    //多条件查询测试  参数为model
    @Test
    public void testMutilCondition() throws IOException {
        SqlSession session = MyBatisUtil.getSession();
        IUserInfoDao mapper = session.getMapper(IUserInfoDao.class);
        ConditionModel conditionModel=new ConditionModel();
        conditionModel.setName("大乐");
        conditionModel.setSex("男");
        List<UserInfo> userInfos = mapper.multiConditionByModel(conditionModel);
        for (UserInfo user:userInfos){
            System.out.println(user.getName());
        }
    }

    //实体和数据表列明不一致可以使用resultMap进行映射 测试resultMap
    @Test
    public void testResultMap() throws Exception {
        SqlSession session = MyBatisUtil.getSession();
        IEmpDao mapper = session.getMapper(IEmpDao.class);
        List<Emp> list = mapper.findEmpAll();
        for (Emp item:list){
            System.out.println(item.getEmpnames());
        }
    }

    //@Param注解测试
    @Test
    public void findByLikeUserNameTest2() throws Exception {
        SqlSession session = MyBatisUtil.getSession();
        IUserInfoDao mapper = session.getMapper(IUserInfoDao.class);
        List<UserInfo> list = mapper.findByLikeUserName("小");
        for (UserInfo item:list){
            System.out.println(item.getName());
        }
    }

    //查询全部
    @Test
    public void test() throws Exception {
        SqlSession session = MyBatisUtil.getSession();
        IUserInfoDao mapper = session.getMapper(IUserInfoDao.class);
        List<UserInfo> list = mapper.findAll();
        for (UserInfo item:list){
            System.out.println(item.getName());
        }
    }

    //sqlsession中的方法
    /**
     * 查询全部
     *
     * @throws IOException
     */
    @Test
    public void findAllTest() throws Exception {

        IUserInfoDao userInfoDao = new UserInfoDaoImpl();
        List<UserInfo> list = userInfoDao.findAll();
        for (UserInfo item : list
                ) {
            System.out.println(item.getName());
        }
    }

    /**
     * 按照用户名模糊查询  sqlsession中的方法
     *
     * @throws IOException
     */
    @Test
    public void findByLikeUserNameTest() throws Exception {

        IUserInfoDao userInfoDao = new UserInfoDaoImpl();
        List<UserInfo> list = userInfoDao.findByLikeUserName("小");
        for (UserInfo item : list
                ) {
            System.out.println(item.getName());
        }
    }


    /**
     * 按照用户名查询
     *
     * @throws IOException
     */
    @Test
    public void findByUserNameTest() throws Exception {

        IUserInfoDao userInfoDao = new UserInfoDaoImpl();
        UserInfo userInfo = userInfoDao.findByUserName("小红");
        System.out.println(userInfo.getAge());
    }

    /**
     * 添加
     *
     * @throws IOException
     */
    @Test
    public void insertUserinfo() throws Exception {
        IUserInfoDao userInfoDao = new UserInfoDaoImpl();
        UserInfo userInfo=new UserInfo();
        userInfo.setName("蔡全武");
        userInfo.setSex("男");
        userInfo.setAge(26);
        userInfo.setDeptno(3);

        int count = userInfoDao.insertUserInfo(userInfo);
        System.out.println(count);
    }


}
