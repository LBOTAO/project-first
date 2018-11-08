package cn.mybatis.day01base.dao.impl;

import cn.mybatis.day01base.dao.IUserInfoDao;
import cn.mybatis.day01base.entity.ConditionModel;
import cn.mybatis.day01base.entity.UserInfo;
import cn.mybatis.day01base.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-10-30 15:44
 */
public class UserInfoDaoImpl implements IUserInfoDao{

    @Override
    public List<UserInfo> findAll() throws Exception{
        String resource="mybatis-config.xml";
        //以流的方式获取到配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        //通过配置文件获取会话工厂
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(is);
        //通过会话工厂获取会话
        SqlSession session = sf.openSession();
        //调用查询方法
        List<UserInfo> list = session.selectList("findAll");
        return list;
    }

    @Override
    public List<UserInfo> findByLikeUserName(String name) throws IOException {
        String resource="mybatis-config.xml";
        //以流的方式回去到配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        //通过配置文件获取会话工厂
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        //打开会话
        SqlSession session = sessionFactory.openSession();
        List<UserInfo> userInfos = session.selectList("findByLikeUserName",name);
        return userInfos;
    }

    @Override
    public UserInfo findByUserName(String name) throws IOException {
        String resource="mybatis-config.xml";
        //以流的方式回去到配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        //通过配置文件获取会话工厂
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        //打开会话
        SqlSession session = sessionFactory.openSession();
        UserInfo userInfos = session.selectOne("findByUserName",name);
        return userInfos;
    }

    @Override
    public int insertUserInfo(UserInfo userInfo) throws IOException {
        String resource="mybatis-config.xml";
        //以流的方式回去到配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        //通过配置文件获取会话工厂
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        //打开会话
        SqlSession session = sessionFactory.openSession();
        int count = session.insert("insertUserInfo",userInfo);
        session.commit();
        return count;
    }

    @Override
    public List<UserInfo> multiConditionByModel(ConditionModel conditionModel) {
        return null;
    }

    @Override
    public List<UserInfo> multiConditionByMap(Map<String, Object> map) {
        return null;
    }
}
