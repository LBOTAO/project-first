package cn.happy.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-09 16:48
 */
public class Province {

    private Integer id;
    private String code;
    private String name;
    private List<City> citys=new ArrayList<>();

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
