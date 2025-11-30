// Dans src/main/java/org/example/backlogmanager/repository/ProductBacklogRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.ProductBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductBacklogRepository extends JpaRepository<ProductBacklog, Long> {

    // --- Fonctions de Recherche et de Relation ---

    /**
     * Trouve le Product Backlog associé à un Projet spécifique.
     * Cette méthode est essentielle car le Product Backlog est propre à un seul projet.
     * Elle repose sur la relation OneToOne (project) définie dans l'entité ProductBacklog.
     */
    Optional<ProductBacklog> findByProjectId(Long projectId);
}