package com.learn.system.model;

public class Teacher {

    private Integer id;

    private String teacherId;

    private Byte sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", sex=" + sex +
                '}';
    }
}
