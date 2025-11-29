package org.example.backlogmanager.repository;

import org.example.backlogmanager.model.Project;

public interface ProjectRepository extends GenericRepository<Project, Long>{

    boolean existsByName(String name);

}
