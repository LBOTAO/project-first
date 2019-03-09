package cn.happy.day05contextmap.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-12-01 9:40
 */
public class Demo1Action extends ActionSupport {
    public String demo1(){
        //使用ActionContext向ContextMap中put数据
        ActionContext context=ActionContext.getContext();  //从当前线程获取ActionContext的对象
        context.put("contextMap","hello contextMap");

        //向应用域中存入数据  两种方式  使用原始servletapi的ServletActionContext对象
        ServletContext application1 = ServletActionContext.getServletContext();
        application1.setAttribute("application","add application success");
        //根据key从ActionContext中获取应用域中的map  往map中存入数据
        Map<String, Object> application2 = context.getApplication();
        application2.put("applicationKey","add applicationKey success");

        //向会话域中存入数据  两种方式  使用原始servletapi的ServletActionContext对象
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("sessionServlet","add sessionServlet succcess");

        Map<String, Object> session1 = context.getSession();
        session1.put("sessionKey","add sessionKey success");
        return SUCCESS;
    }
}
