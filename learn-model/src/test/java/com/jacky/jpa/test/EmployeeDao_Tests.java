package com.jacky.jpa.test;

import com.jacky.jpa.dao.DepartmentDao;
import com.jacky.jpa.dao.EmployeeDao;
import com.jacky.jpa.model.Department;
import com.jacky.jpa.model.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Transactional
public class EmployeeDao_Tests extends AbstractDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao deptDao;

    @Test
    public void save_test() {

        Department d = new Department();

        d.setName("dept1");
        deptDao.save(d);

        Employee ee = new Employee();
        ee.setName("ee1");
        ee.setDept(d);

        Employee ee2 = new Employee();
        ee2.setName("ee2");
        ee2.setDept(d);

        Employee save = employeeDao.save(ee);
        employeeDao.save(ee2);
        System.out.println(save.getId());
        assertNotNull(save.getId());
    }

    @Test
    public void findAll_test() {
        Department d = new Department();

        d.setName("dept1");
        deptDao.save(d);
        Employee ee = new Employee();
        ee.setName("ee1");
        ee.setDept(d);

        Employee ee2 = new Employee();
        ee2.setName("ee2");
        ee2.setDept(d);

        employeeDao.save(ee);
        employeeDao.save(ee2);

        List<Employee> all = employeeDao.findAll();
        assertEquals(2, all.size());
    }
}
