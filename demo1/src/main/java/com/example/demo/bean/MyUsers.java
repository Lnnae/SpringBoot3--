package com.example.demo.bean;

/**
 * @author 韩伟Q
 */
public class MyUsers {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyUsers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
