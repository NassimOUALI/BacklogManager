// Dans src/main/java/org/example/backlogmanager/repository/SprintRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    // --- Fonctions de Gestion de Projet ---

    /**
     * Trouve tous les Sprints associés à un Projet spécifique.
     * Essentiel pour la gestion des Sprints dans le contexte d'un projet donné.
     */
    List<Sprint> findByProjectId(Long projectId);

    /**
     * Trouve un Sprint par son nom.
     * Utile pour la recherche rapide (ex: "Sprint 1", "Sprint de Mars").
     */
    Optional<Sprint> findByName(String name);

    // --- Fonctions de Suivi de Temps ---

    /**
     * Trouve les Sprints actifs ou futurs qui se déroulent pendant une période donnée.
     * Permet d'identifier si un Sprint est en cours ou planifié.
     */
    List<Sprint> findByStartDateBeforeAndEndDateAfter(LocalDate dateA, LocalDate dateB);

    /**
     * Trouve tous les Sprints qui sont terminés avant une date donnée.
     * Utile pour l'historique des sprints (reporting).
     */
    List<Sprint> findByEndDateBefore(LocalDate date);
}