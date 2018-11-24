package cn.happy.day05annotationdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 15:04
 */
/*@Component
@Scope("prototype")*/
@Controller("hehe")
public class Publisher {

    public Publisher() {
        System.out.println("对象已创建。。。。");
    }

    @Value("清华大学出版社")
    private String publisherName;

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                '}';
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
