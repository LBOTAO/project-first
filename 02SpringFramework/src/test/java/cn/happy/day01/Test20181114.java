package cn.happy.day01;

import cn.happy.day01.dao.impl.CustomerDaoImpl;
import cn.happy.day01.factory.BeanFactory;
import cn.happy.day01.service.ICustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:43
 */
public class Test20181114 {
    /**
     * 程序间耦合度的解决
     */
    @Test
    public void test() throws Exception {
        ICustomerService service = (ICustomerService) BeanFactory.getBean("CUSTOMERSERVICE");
        service.saveCustomer();
    }

    /**
     * 对于控制反转的第一个测试
     */
    @Test
    public void getBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDaoImpl customerDaoImpl = (CustomerDaoImpl)ctx.getBean("customerDaoImpl");
        System.out.println(customerDaoImpl);
    }

}
