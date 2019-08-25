package com.jacky.jpa.test;

import com.jacky.jpa.dao.ProjectDao;
import com.jacky.jpa.model.Project;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@Transactional
public class IdGeneratedValue_Tests extends AbstractDaoTest{

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void save_test() {
        Project project = new Project();
        project.setId("project_1");
        project.setName("project_exam");

        projectDao.save(project);
    }

    @Test
    public void test1() {
        Project project = new Project();
        project.setId("project_1");
        project.setName("project_exam");

       projectDao.save(project);

        Optional<Project> optional = projectDao.findById("project_1");

        assertTrue(optional.isPresent());
    }
}
