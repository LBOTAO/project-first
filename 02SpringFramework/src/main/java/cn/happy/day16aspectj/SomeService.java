package cn.happy.day16aspectj;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 15:09
 */
public class SomeService {
    public void doSome(){
        System.out.println("proxyfactorybean aop");
    }

    public Integer add(){
        System.out.println("add function");
        return 6;
    }
    public int delete(){
        int result=5/0;
        System.out.println("delete function");
        return 2;
    }
}
