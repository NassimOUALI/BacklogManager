// Dans src/main/java/org/example/backlogmanager/repository/ProjectRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // --- Fonctions de Recherche de Base ---

    /**
     * Trouve un projet par son nom (souvent utilisé pour l'unicité ou la recherche).
     */
    Optional<Project> findByName(String name);

    // --- Fonctions de Gestion des Rôles (Basées sur le Cahier des Charges) ---

    /**
     * Trouve tous les projets gérés par un Product Owner spécifique.
     * Répond à l'exigence de gestion du Product Backlog par le Product Owner.
     */
    List<Project> findByProductOwnerId(Long productOwnerId);

    /**
     * Trouve tous les projets facilités par un Scrum Master spécifique.
     * Répond à l'exigence de suivi du déroulement des sprints par le Scrum Master.
     */
    List<Project> findByScrumMasterId(Long scrumMasterId);

    // --- Fonctions de Gestion d'Équipe (Relation Many-to-Many) ---

    /**
     * Trouve tous les projets auxquels un développeur spécifique est affecté.
     * Essentiel pour que les développeurs puissent voir leur travail.
     * (Nécessite une jointure interne via la relation ManyToMany)
     */
    List<Project> findByDevelopersId(Long developerId);

    // --- Fonctions de Suivi des Projets ---

    /**
     * Trouve les projets qui ont démarré avant une date donnée.
     */
    List<Project> findByDateDebutBefore(java.time.LocalDate date);
}