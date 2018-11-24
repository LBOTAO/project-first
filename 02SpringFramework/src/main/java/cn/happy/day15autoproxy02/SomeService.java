package cn.happy.day15autoproxy02;

/**
 * author：  刘涛
 *
 * @create 2018-11-22 15:09
 */
public class SomeService {
    public void doSome(){
        System.out.println("proxyfactorybean aop");
    }

    public int add(){
        System.out.println("add function");
        return 6;
    }
    public int delete(){
        System.out.println("delete function");
        return 2;
    }
}
