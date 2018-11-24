package cn.happy.day12advisor;

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
     * proxyfactorybean  顾问    测试
     */
    @Test
    public void testProxyFactoryBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay12advisor.xml");
        SomeService proxyFactoryBean =(SomeService) ctx.getBean("proxyFactory");
        proxyFactoryBean.doSome();
        proxyFactoryBean.add();
        proxyFactoryBean.delete();
    }
}
