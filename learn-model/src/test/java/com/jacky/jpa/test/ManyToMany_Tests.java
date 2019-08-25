package com.jacky.jpa.test;

import com.jacky.jpa.dao.EmployeeDao;
import com.jacky.jpa.dao.ProjectDao;
import com.jacky.jpa.model.Employee;
import com.jacky.jpa.model.Project;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Transactional
public class ManyToMany_Tests extends AbstractDaoTest {

    @Autowired
    private EmployeeDao empDao;

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void save_test() {
        Employee emp1 = new Employee();
        emp1.setName("Jacky");
        empDao.save(emp1);
        System.out.println(emp1.getId());

        Employee emp2 = new Employee();
        emp2.setName("Tom");
        empDao.save(emp2);

        System.out.println(emp2.getId());

        Set<Employee> emps = new HashSet<>();
        emps.add(emp1);
        emps.add(emp2);

        Project project1 = new Project();
        project1.setName("project-exam");
        project1.setId("project_001");
        project1.setEmps(emps);

        projectDao.save(project1);


        Optional<Project> p = projectDao.findById(project1.getId());
        assertTrue(p.isPresent());
        assertEquals(2, p.get().getEmps().size());

        Set<Project> projectSet = new HashSet<>();
        projectSet.add(project1);
        emp1.setProjects(projectSet);

        Optional<Employee> employeeOptional = empDao.findById(emp1.getId());
        assertTrue(employeeOptional.isPresent());
        assertEquals(1, employeeOptional.get().getProjects().size());
    }
}
