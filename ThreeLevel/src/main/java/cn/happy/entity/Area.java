package cn.happy.entity;

/**
 * author：  刘涛
 *
 * @create 2018-11-09 16:45
 */
public class Area {
    private Integer id;
    private String code;
    private String name;
    private String citycode;

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

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
}
