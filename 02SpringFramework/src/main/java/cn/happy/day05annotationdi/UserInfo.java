package cn.happy.day05annotationdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 15:16
 */
@Component
public class UserInfo {
    @Value("${user.id}")
    private Integer id;
    @Value("${user.username}")
    private String name;
    @Value("${user.describe}")
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
