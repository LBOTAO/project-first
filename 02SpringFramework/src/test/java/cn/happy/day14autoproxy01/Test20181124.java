package cn.happy.day14autoproxy01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-24 14:28
 */
public class Test20181124 {

    /**
     * defaultAdvisorAuaoProxyCreator   默认顾问自动代理生成
     */
    @Test
    public void testProxyFactoryBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay14autoproxy01.xml");
       SomeService proxyFactoryBean =(SomeService) ctx.getBean("someService");
        proxyFactoryBean.doSome();
        proxyFactoryBean.add();
        proxyFactoryBean.delete();
    }
}
