package cn.happy.day01helloworld.action;

import com.opensymphony.xwork2.Action;

/**
 * author：  刘涛
 * 实际开发中用的不多
 * @create 2018-11-29 9:19
 */
public class Hello2Action implements Action {
    /**
     *
     * Action接口中的常量
         SUCCESS：一般多用于成功
         ERROR：一般多用于动作方法执行失败
         LOGIN：一般多用于返回登录页面
         NONE：一般用于不返回任何结果视图，和return null作用是一样的
         INPUT：一般多用于数据回显，也是struts2中数据回显时的默认返回值。

     *
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        System.out.println("implements Action 执行了。。。。。。");
        return SUCCESS;
    }
}
