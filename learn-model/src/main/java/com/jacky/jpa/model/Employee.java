package com.jacky.jpa.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TBL_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "EMP_ID")
    private String id;

    @Column(name = "EMP_NAME")
    private String name;

    @ManyToOne
    // 可以不用设置JoinColumn，如果不配置，默认的列名为dept_dept_id
    @JoinColumn(name = "DEPT_ID")
    private Department dept;

    @ManyToMany
    private Set<Project> projects;


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

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
