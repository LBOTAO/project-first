package cn.happy.day01base.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 抽取hibernate的工具类
 * @author zhy
 *
 */
public class HibernateUtil {

	private static SessionFactory factory;
	private static Session session;
	
	//了解：hibernate把可以预见的异常都转成了运行时异常
	static{
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			factory = cfg.buildSessionFactory();
		} catch (ExceptionInInitializerError e) {
			throw new ExceptionInInitializerError("初始化SessionFactory失败，请检查配置文件");
		}
	}
	
	/**
	 * 获取一个新的Session对象
	 * @return
	 */
	public static Session openSession(){
		session= factory.openSession();
		return session;
	}

	public static Session getCurentSession(){
		return factory.getCurrentSession();   //只有设置了session与线程绑定才能使用此方法   而且不用我们手动关闭session
	}

	public static void main(String[] args) {
		getCurentSession();
	}
}
