package com.jacky.jpa.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TBL_DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "DEPT_ID")
    private String id;

    @Column(name = "DEPT_NAME")
    private String name;

    @OneToMany(mappedBy = "dept")
    private Collection<Employee> emp;

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

    public Collection<Employee> getEmp() {
        return emp;
    }

    public void setEmp(Collection<Employee> emp) {
        this.emp = emp;
    }
}
