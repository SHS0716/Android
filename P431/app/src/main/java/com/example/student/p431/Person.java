package com.example.student.p431;

public class Person  {
    int img;
    String id;
    String name;
    String dept;

    public Person(){

    }

    public Person(int img, String id, String name, String dept) {
        this.img = img;
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Person{" +
                "img=" + img +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
