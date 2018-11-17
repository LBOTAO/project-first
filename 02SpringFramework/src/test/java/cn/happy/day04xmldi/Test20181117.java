package cn.happy.day04xmldi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:43
 */
public class Test20181117 {
    //p命名空间注入
    @Test
    public void pNameSpanceInjectionTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        Student student = (Student)ctx.getBean("pNameSpance");
        System.out.println(student);
    }

    //02构造注入
    @Test
    public void constructoInjectionrTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        Student student = (Student)ctx.getBean("student");
        System.out.println(student);
    }

   //set方法注入
    @Test
    public void setInjectionTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        Person person = (Person)ctx.getBean("person");
        System.out.println(person);
    }
}
