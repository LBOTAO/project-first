package cn.happy.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * author：  刘涛
 *
 * @create 2018-11-09 16:46
 */
public class City {
    private Integer id;
    private String code;
    private String name;
    private String provincecode;

    private List<Area> areas=new ArrayList<Area>();

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
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

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }
}
