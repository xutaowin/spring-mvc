package com.dbapp.springmvc.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/10/3
 * @Time： 20:51
 */
@XmlRootElement
public class Employee {
    private int id;
    private String name;
    private int age;
    private int deptId;

    public Employee(){

    }

    public Employee(int id, String name, int age, int deptId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
