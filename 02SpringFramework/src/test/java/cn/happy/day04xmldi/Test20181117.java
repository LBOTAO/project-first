package cn.happy.day04xmldi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * author：  刘涛
 *
 * @create 2018-11-14 17:43
 */
public class Test20181117 {
    //集合注入--- map
    @Test
    public void propertiesTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        MyCollection collection = (MyCollection)ctx.getBean("properties");
        Properties properties = collection.getProperties();
        System.out.println(properties);
    }
    //集合注入--- map
    @Test
    public void mapTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        MyCollection collection = (MyCollection)ctx.getBean("map");
        Map<String, String> map = collection.getMap();
        for (Map.Entry<String, String> item :map.entrySet()){
            System.out.println(item.getKey()+"---"+item.getValue());
        }
    }
    //集合注入--- set
    @Test
    public void setTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        MyCollection collection = (MyCollection)ctx.getBean("set");
        Set<String> set = collection.getSet();
        System.out.println(set);
    }
    //集合注入--- list
    @Test
    public void listTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        MyCollection collection = (MyCollection)ctx.getBean("list");
        List<String> list = collection.getList();
        System.out.println(list);
    }
    //集合注入--- array
    @Test
    public void arrayTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextDay04xmldi.xml");
        MyCollection collection = (MyCollection)ctx.getBean("array");
        String[] array = collection.getArray();
        List<String> list = Arrays.asList(array);
        System.out.println(list);
    }

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
