package com.jacky.jpa.dao;

import com.jacky.jpa.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, String> {
}
