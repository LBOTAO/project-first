package cn.happy.day18jdbctemplate;

import cn.happy.day18jdbctemplate.entity.Emp;
import cn.happy.day18jdbctemplate.service.IEmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-27 11:05
 */
public class Test20181127 {

    @Test
    public void test02(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay18jdbctemplate.xml");
        IEmpService empService = (IEmpService)ctx.getBean("empService");
        Emp emp =new Emp();
        emp.setEmpname("王浩");
        emp.setEmpphone("15931787952");
        empService.addEmp(emp);

    }

    @Test
    public void test01(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay18jdbctemplate.xml");
        IEmpService empService = (IEmpService)ctx.getBean("empService");
        List<Emp> empList = empService.findAll();
        for (Emp emp:empList){
            System.out.println(emp.getEmpid()+"\t"+emp.getEmpname());
        }

    }
}
