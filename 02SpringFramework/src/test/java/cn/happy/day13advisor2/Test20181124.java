package cn.happy.day13advisor2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-24 14:05
 */
public class Test20181124 {
    /**
     * proxyfactorybean  正则顾问    测试
     */
    @Test
      public void testProxyFactoryBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay13advisor02.xml");
        SomeService proxyFactoryBean =(SomeService) ctx.getBean("proxyFactory");
        proxyFactoryBean.doSome();
        proxyFactoryBean.add();
        proxyFactoryBean.delete();
    }
}
