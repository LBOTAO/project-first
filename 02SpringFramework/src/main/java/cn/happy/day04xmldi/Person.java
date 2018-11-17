package cn.happy.day04xmldi;

import lombok.*;

/**
 * author：  刘涛
 *
 * @create 2018-11-17 15:29
 */
public class Person {
    private String name;
    private Car car;



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
