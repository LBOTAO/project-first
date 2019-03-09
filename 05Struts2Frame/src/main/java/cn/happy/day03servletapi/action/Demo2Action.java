package cn.happy.day03servletapi.action;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * 访问ServletAPI:
 * 	有两种方式：
 * 	第二种方式：
 * 		通过实现不同的接口，获取不同的对象。
 * 		要想使用request，需要实现ServletRequestAware
 * 		要想使用response，需要实现ServletResponseAware
 * 		要想使用servletContext，需要实现SerlvetContextAware
 * 输出结果之后，找出其中一个和其他三个不一样：
 * 		org.apache.struts2.dispatcher.StrutsRequestWrapper@1c6e453		它和其他三个不一样，它是struts2提供的
 org.apache.catalina.connector.ResponseFacade@b846ae
 org.apache.catalina.core.ApplicationContextFacade@287809
 org.apache.catalina.session.StandardSessionFacade@e0d480


 如果说是一对种方式获取ServletAPI象：ActionContext中的get(key)
 如果说是三种方式获取ServletAPI对象，除了我们讲的两种之外，也可以使用ActionContext获取

 通过分析源码，我们得知，ActionContext看上去是一个类似Map的结构。
 map的key是String类型，Map的value是Object类型
 * @author 刘涛
 *
 */
public class Demo2Action implements ServletRequestAware,ServletResponseAware,ServletContextAware{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private ServletContext application;
    public String demo(){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        System.out.println(application);
        return SUCCESS;
    }
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
        this.session = httpServletRequest.getSession();
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response=httpServletResponse;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.application=servletContext;
    }
}
