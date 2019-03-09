package cn.happy.day06interceptor.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器
 * 步骤：
 * 	第一步：编写一个普通类，继承AbstractInterceptor（也可以实现Interceptor接口）
 * 	第二步：配置拦截器
 * 		<!-- 声明一个拦截器 -->
 <interceptors>
 <interceptor name="myInterceptor" class="com.itheima.web.interceptors.MyInterceptor"></interceptor>
 </interceptors>
 <!-- 引用拦截器：写在action标签的内部。当我们写了自己的拦截器引用时，默认的拦截器栈就失效了 -->
 <interceptor-ref name="myInterceptor"></interceptor-ref>
 拦截器的放行：
 invocation.invoke();
 返回值的内容是：
     动作方法的返回值
 关于结果视图的执行时机以及拦截器的返回值问题
     在放行之前，拦截器的返回值可以控制显示哪个结果视图。一旦放行之后，它一定会显示动作方法返回值所匹配的结果视图，此时已经不管拦截器返回什么内容。
 多个拦截器的执行顺序问题：
     是由引用顺序决定的，与声明顺序无关
 * @author  刘涛
 *
 */
public class MyInterceptor extends AbstractInterceptor {
    /**
     *
     * @param invocation
     * @return action的返回值
     * @throws Exception
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("action执行前拦截1111111111111。。。。");
        String invoke = invocation.invoke();
        System.out.println("action执行后拦截1111111111111。。。。");
        return invoke;
    }
}
