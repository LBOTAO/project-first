package cn.happy.day06interceptor.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * 多个拦截器的执行顺序：  与引用顺序有关，与声明顺序无关。
 */
public class MyInterceptor2 extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("action执行前拦截222222222222222。。。。");
        String invoke = invocation.invoke();
        System.out.println("action执行后拦截222222222222222。。。。");
        return invoke;
    }
}
