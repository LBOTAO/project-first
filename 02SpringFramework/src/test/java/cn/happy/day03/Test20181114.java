package cn.happy.day03;

import cn.happy.day02paper.Print;
import cn.happy.day03.entity.User;
import cn.happy.day03.service.IUserService;
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
