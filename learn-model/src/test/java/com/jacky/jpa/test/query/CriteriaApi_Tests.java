package com.jacky.jpa.test.query;

import com.jacky.jpa.dao.EmployeeDao;
import com.jacky.jpa.test.AbstractDaoTest;
import org.springframework.beans.factory.annotation.Autowired;

public class CriteriaApi_Tests extends AbstractDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    public void test1() {
        employeeDao.findAll();
    }
}
