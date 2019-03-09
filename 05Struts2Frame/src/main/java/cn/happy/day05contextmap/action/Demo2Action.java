package cn.happy.day05contextmap.action;

import cn.happy.day05contextmap.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * author：  刘涛
 *
 * @create 2018-12-01 9:40
 */
public class Demo2Action extends ActionSupport {
    private String name="林浅";

    public String getName() {
        return name;
    }

    //使用ActionContext向valueStack中存入数据  并进行压栈操作
    public String demo2(){
        ActionContext context=ActionContext.getContext();
        ValueStack valueStack = context.getValueStack();
        Student student=new Student("金瀚",18,"男");
        valueStack.push(student);
        return SUCCESS;
    }
}
