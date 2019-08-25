package com.jacky.jpa.test.query;

import com.jacky.jpa.dao.DepartmentDao;
import com.jacky.jpa.dao.EmployeeDao;
import com.jacky.jpa.model.Department;
import com.jacky.jpa.model.Employee;
import com.jacky.jpa.test.AbstractDaoTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DynamicQuery_Tests extends AbstractDaoTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao deptDao;

    @Before
    public void setUp() {
        Employee ee = new Employee();
        ee.setName("ZhangSan");
        ee.setEmpCode("001");

        Employee ee2 = new Employee();
        ee2.setName("Zhangliwei");
        ee2.setEmpCode("002");

        Department d = new Department();

        d.setName("dept1");
        deptDao.save(d);

        ee.setDept(d);
        ee2.setDept(d);
        employeeDao.save(ee);
        employeeDao.save(ee2);
    }

    @Test
    public void test1() {
        assertNotNull(em);
        System.out.println(em);
    }

    @Test
    public void test2() {
        String queryJPQ = "select e from Employee e where e.empCode = :empCode";
        List<Employee> emps = em.createQuery(queryJPQ, Employee.class).setParameter("empCode", "001").getResultList();

        assertEquals(1, emps.size());
    }

    @Test
    public void test3() {
        String queryJPQ = "select e from Employee e where e.name like :name and e.dept.name = :deptName";
        List<Employee> emps = em.createQuery(queryJPQ, Employee.class)
                .setParameter("name", "Zhang%")
                .setParameter("deptName", "dept1")
                .getResultList();
        assertEquals(2, emps.size());
    }
}
