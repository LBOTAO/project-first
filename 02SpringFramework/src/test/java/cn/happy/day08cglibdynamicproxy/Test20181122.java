package cn.happy.day08cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 14:28
 */
public class Test20181122 {

    /**
     * 今天是个特殊的日子 ☺    。。。。。
     */



    /**
     * cglib动态代理
     */
    @Test
    public void test(){
        final StudentService service=new StudentService();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("增强========");
                Object invoke = methodProxy.invoke(service, objects);
                return invoke;
            }
        });
        StudentService o =(StudentService) enhancer.create();
        o.addStu();
    }

}
