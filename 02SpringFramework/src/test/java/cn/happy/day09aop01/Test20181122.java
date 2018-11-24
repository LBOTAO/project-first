package cn.happy.day09aop01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 15:15
 */
public class Test20181122 {
    /**
     * proxyfactorybean  后置增强   测试
     */
    @Test
    public void testProxyFactoryBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay09aop01.xml");
        SomeService proxyFactoryBean =(SomeService) ctx.getBean("proxyFactoryBean");
        proxyFactoryBean.doSome();
    }

    /**
     * proxyfactorybean  前置增强   测试
     */
    @Test
    public void testProxyFactoryBeanBefore(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay09aop01.xml");
        SomeService proxyFactoryBean =(SomeService) ctx.getBean("proxyFactoryBeanBefore");
        proxyFactoryBean.doSome();
    }
}
