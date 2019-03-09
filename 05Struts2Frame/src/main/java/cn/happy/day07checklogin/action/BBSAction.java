package cn.happy.day07checklogin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * author：  刘涛
 *
 * @create 2018-12-02 11:58
 */
public class BBSAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
    public String demo1(){
        System.out.println(request);
        return SUCCESS;
    }

    public String demo2(){
        System.out.println(request);
        return SUCCESS;
    }

    public String demo3(){
        System.out.println(request);
        return SUCCESS;
    }

    public String userLogin(){
        ServletActionContext.getRequest().getSession().setAttribute("userinfo","");
        return SUCCESS;
    }

}
