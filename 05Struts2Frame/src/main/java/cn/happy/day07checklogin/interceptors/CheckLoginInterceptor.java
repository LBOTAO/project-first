package cn.happy.day07checklogin.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * author：  刘涛
 *
 * @create 2018-12-02 12:00
 */
public class CheckLoginInterceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Object userinfo = ServletActionContext.getRequest().getSession().getAttribute("userinfo");
        if (userinfo==null){
            System.out.println("登录已拦截。。。。。");
            return "login";
        }
        return invocation.invoke();
    }
}
