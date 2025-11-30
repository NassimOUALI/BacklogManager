// Dans src/main/java/org/example/backlogmanager/repository/TaskRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.Task;
import org.example.backlogmanager.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // --- Fonctions de Suivi des Tasks par User Story ---

    // 1. Trouver toutes les tâches associées à une User Story spécifique
    // Essentiel pour la vue détaillée des User Stories et du Sprint Backlog 
    List<Task> findByUserStoryId(Long userStoryId);

    // 2. Trouver toutes les tâches d'une User Story dans un statut donné
    // Permet de vérifier rapidement si une User Story a des tâches "In Progress" ou "Done"
    List<Task> findByUserStoryIdAndStatus(Long userStoryId, Status status);


    // --- Fonctions d'Affectation et de Suivi Développeur ---

    // 3. Trouver toutes les tâches assignées à un développeur spécifique
    // Utile pour que le développeur puisse voir sa liste de travail (To Do List) 
    List<Task> findByAssignedDeveloperId(Long developerId);

    // 4. Trouver les tâches assignées à un développeur, filtrées par statut
    // Permet de voir le travail "In Progress" ou "To Do" d'un développeur
    List<Task> findByAssignedDeveloperIdAndStatus(Long developerId, Status status);

    // --- Fonctions de Statut ---

    // 5. Trouver toutes les tâches ayant un statut spécifique (ex: toutes les tâches "Done")
    List<Task> findByStatus(Status status);
}