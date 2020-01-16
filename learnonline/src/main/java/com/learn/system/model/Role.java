package com.learn.system.model;

import java.sql.Timestamp;

public class Role {

    private Integer id;

    private String name;

    private Timestamp creattime;

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

    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creattime=" + creattime +
                '}';
    }
}
