package cn.mybatis.test;

import cn.mybatis.day01base.dao.IUserInfoDao;
import cn.mybatis.day01base.entity.UserInfo;
import cn.mybatis.day01base.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-13 14:04
 */
public class Test20181113 {
    //增删改对一级缓存的影响
    @Test
    public void testCache() throws Exception {
        SqlSession session = MyBatisUtil.getSession();
        IUserInfoDao mapper = session.getMapper(IUserInfoDao.class);
        List<UserInfo> list = mapper.findAll();
        for (UserInfo item:list){
            System.out.println(item.getName());
        }
        MyBatisUtil.closeSession();
        UserInfo userInfo=new UserInfo();
        userInfo.setName("陈娜");
        userInfo.setSex("0");
        userInfo.setAge(18);
        userInfo.setDeptno(2);
        mapper.insertUserInfo(userInfo);
        MyBatisUtil.closeSession();
        System.out.println("---------------------------------");
        List<UserInfo> list2 = mapper.findAll();
        for (UserInfo item:list2){
            System.out.println(item.getName());
        }
        MyBatisUtil.closeSession();
    }

    /**
     * 测试二级缓存
     * @throws Exception
     */
    @Test
    public void testCache2() throws Exception {
        SqlSession session = MyBatisUtil.getSession();
        IUserInfoDao mapper = session.getMapper(IUserInfoDao.class);
        List<UserInfo> list = mapper.findAll();
        for (UserInfo item:list){
            System.out.println(item.getName());
        }
        MyBatisUtil.closeSession();
        System.out.println("---------------------------------");
        SqlSession session2 = MyBatisUtil.getSession();
        IUserInfoDao mapper2 = session2.getMapper(IUserInfoDao.class);
        List<UserInfo> list2 = mapper2.findAll();
        for (UserInfo item:list2){
            System.out.println(item.getName());
        }
        MyBatisUtil.closeSession();
    }
}
