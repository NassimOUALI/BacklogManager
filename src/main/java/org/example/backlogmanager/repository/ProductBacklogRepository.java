package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.ProductBacklog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBacklogRepository extends JpaRepository<ProductBacklog, Long> {
}
