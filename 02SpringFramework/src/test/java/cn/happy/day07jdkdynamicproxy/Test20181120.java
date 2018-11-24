package cn.happy.day07jdkdynamicproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 17:36
 */
public class Test20181120 {
    @Test
    public void testJdkDynamicProxy(){
        final StudentImpl student=new StudentImpl();
        /**
         * Proxy.newProxyInstance(三个参数)
         * 参数说明：
         * ClassLoader ： 和被代理对象使用相同的类加载器
         * interfaces ：和被代理类具有相同的行为 实现相同的接口
         * InvocationHandler：使用什么样的处理
         */
        IStudent stu = (IStudent)Proxy.newProxyInstance(student.getClass().getClassLoader(), student.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *  执行被代理对象的 的任何方法  都会经过该方法
             *  具有拦截的功能
             *
             * @param proxy  代理对象的引用
             * @param method 当前执行的方法 对象
             * @param args  执行方所需的参数
             * @return    当前执行方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before---");
                Object invoke = method.invoke(student, args);
                return invoke;
            }
        });
        stu.add();
    }
}
