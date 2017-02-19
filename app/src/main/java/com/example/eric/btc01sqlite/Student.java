package com.example.eric.btc01sqlite;

/**
 * Created by Eric on 2017/2/18.
 */

public class Student {
    private Integer id;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    private Integer age;
    private Integer height;

    @Override
    public String toString() {
        return "ID:"+id+",NAME:"+name+",AGE:"+age+"HEIGHT:"+height+"\n";
    }
}
