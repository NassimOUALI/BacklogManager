package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.SprintBacklog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintBacklogRepository extends JpaRepository<SprintBacklog, Long> {

}
