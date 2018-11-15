package cn.happy.day02paper;

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
     * 控制反转  打印机案例 test
     */
    @Test
    public void getBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay02Paper.xml");
        Print customerDaoImpl = (Print)ctx.getBean("print");
        customerDaoImpl.printInfo();
    }

}
