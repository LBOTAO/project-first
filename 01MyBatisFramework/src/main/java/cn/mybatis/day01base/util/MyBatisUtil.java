package cn.mybatis.day01base.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * author：  刘涛
 *
 * @create 2018-11-01 15:08
 */
public class MyBatisUtil {
    static String resource="mybatis-config.xml";
    static InputStream is;
    //以流的方式获取到配置文件
   static {
        try {
           is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //通过配置文件获取会话工厂
    static SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(is);

    static SqlSession session;
    public static SqlSession getSession() throws IOException {
        //通过会话工厂获取会话
            session = sf.openSession(true);
        return session;
    }

    public static void closeSession(){
        session.close();
    }
}
