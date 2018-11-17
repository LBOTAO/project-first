package cn.happy.day04xmldi;

import lombok.*;

/**
 * author：  刘涛
 *
 * @create 2018-11-17 15:29
 */
public class Car {
    private String color;  //车的颜色
    private String brand;  //车的品牌

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



}
