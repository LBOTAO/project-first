package cn.happy.day10aop02;

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
     * proxyfactorybean  环绕   测试
     */
    @Test
    public void testProxyFactoryBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay10aop02.xml");
        SomeService proxyFactoryBean =(SomeService) ctx.getBean("proxyFactory");
        proxyFactoryBean.doSome();
    }
}
