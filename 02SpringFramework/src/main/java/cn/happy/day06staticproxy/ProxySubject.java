package cn.happy.day06staticproxy;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 16:22
 */
public class ProxySubject implements Subject{
    private Subject subject;
    @Override
    public void findAll() {
        System.out.println("====before----");
        subject.findAll();
        System.out.println("=====after");
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
