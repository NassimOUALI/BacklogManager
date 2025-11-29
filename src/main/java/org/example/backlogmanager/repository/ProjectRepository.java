package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByName(String name);

}
