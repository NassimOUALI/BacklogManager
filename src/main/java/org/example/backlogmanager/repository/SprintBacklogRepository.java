package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.SprintBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SprintBacklogRepository extends JpaRepository<SprintBacklog, Long> {

    // --- Fonctions de Recherche et de Relation ---

    // 1. Trouver le Sprint Backlog par son ID de Sprint
    // Le Sprint Backlog est directement lié à un Sprint via une relation OneToOne.
    // Cette méthode est essentielle pour accéder au backlog à partir du Sprint.
    Optional<SprintBacklog> findBySprintId(Long sprintId);

    // --- Fonctions de Suivi ---

    // Pourrait inclure des méthodes pour vérifier l'état des User Stories dans ce backlog,
    // mais cela est généralement mieux géré par le UserStoryRepository (ex: findBySprintBacklogIdAndStatus).
}