package cn.happy.day17aspectjxml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-24 16:51
 */
public class Test20181124 {
    @Test
    public void testProxyFactoryBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay17aspectjxml.xml");
        SomeService proxyFactoryBean =(SomeService) ctx.getBean("someService");
        proxyFactoryBean.doSome();
        proxyFactoryBean.add();
        proxyFactoryBean.delete();
    }
}
