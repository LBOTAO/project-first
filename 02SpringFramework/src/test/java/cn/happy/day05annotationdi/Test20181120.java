package cn.happy.day05annotationdi;

import cn.happy.day06staticproxy.ProxySubject;
import cn.happy.day06staticproxy.RealSubject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 15:04
 */
public class Test20181120 {

    /**
     * value注解的使用初步
     */
    @Test
    public void testAnnotation(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay05annotationdi.xml");
        Publisher pub1 = (Publisher)ctx.getBean("publisher");
        System.out.println(pub1.getPublisherName());
        Publisher pub2 = (Publisher)ctx.getBean("publisher");
        System.out.println(pub2.getPublisherName());
    }

    /**
     * @Value 读取properties文件内容
     */
    @Test
    public void testPropertiesAnnotation(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay05annotationdi.xml");
        UserInfo userInfo = (UserInfo)ctx.getBean("userInfo");
        System.out.println(userInfo.getId()+"===="+userInfo.getName() +"=="+userInfo.getDescribe());
    }


    /**
     * @Resources autowire 注解使用
     */
    @Test
    public void testResourceAnnotation(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay05annotationdi.xml");
        Book book = (Book)ctx.getBean("book");
        System.out.println(book);
    }

    /**
     * 静态代理的测试
     */
    @Test
    public void testStaticProxy(){
        ProxySubject proxySubject=new ProxySubject();
        RealSubject realSubject=new RealSubject();
        proxySubject.setSubject(realSubject);
        proxySubject.findAll();
    }
}
