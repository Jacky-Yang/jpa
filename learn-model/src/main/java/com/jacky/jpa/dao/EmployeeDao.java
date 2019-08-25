package com.jacky.jpa.dao;

import com.jacky.jpa.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends BaseDao<Employee> {
}
