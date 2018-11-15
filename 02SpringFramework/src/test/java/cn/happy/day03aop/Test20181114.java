package cn.happy.day03aop;

import cn.happy.day03aop.entity.User;
import cn.happy.day03aop.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:43
 */
public class Test20181114 {
    @Test
    public void getBean(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay03.xml");
        IUserService userService = (IUserService)ctx.getBean("userService");
        userService.save(new User());
    }

}
