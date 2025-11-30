// Dans src/main/java/org/example/backlogmanager/repository/UserStoryRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.UserStory;
import org.example.backlogmanager.entities.enums.MoscowPriority;
import org.example.backlogmanager.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    // --- Fonctions de Gestion du Backlog (Product/Sprint) ---

    // 1. Trouver toutes les User Stories dans un Product Backlog donné
    // Essentiel pour la gestion et la priorisation du Product Backlog [cite: 7, 21]
    List<UserStory> findByProductBacklogId(Long productBacklogId);

    // 2. Trouver toutes les User Stories dans un Sprint Backlog donné
    // Essentiel pour le suivi du Sprint en cours [cite: 7, 41]
    List<UserStory> findBySprintBacklogId(Long sprintBacklogId);

    // --- Fonctions de Suivi et de Statut ---

    // 3. Trouver les User Stories par leur statut (To Do, In Progress, Done)
    // Permet de visualiser l'avancement dans le Sprint Backlog [cite: 12, 43]
    List<UserStory> findByStatus(Status status);

    // 4. Trouver les User Stories liées à un Epic spécifique
    // Utile pour la visualisation des Epics [cite: 8, 23, 38]
    List<UserStory> findByEpicId(Long epicId);

    // --- Fonctions de Priorisation et de Tri ---

    // 5. Trouver les User Stories par leur priorité MoSCoW (Must Have, Should Have, etc.)
    // Utilisé comme technique de priorisation [cite: 32]
    List<UserStory> findByMoscowPriority(MoscowPriority moscowPriority);

    // 6. Trier les User Stories d'un Product Backlog par Valeur Métier (décroissante)
    // Utile pour la priorisation selon l'impact sur les utilisateurs/entreprise [cite: 26]
    List<UserStory> findByProductBacklogIdOrderByBusinessValueDesc(Long productBacklogId);

    // 7. Trier les User Stories d'un Product Backlog par Story Points (croissante)
    // Utile pour l'analyse des efforts/coûts [cite: 28]
    List<UserStory> findByProductBacklogIdOrderByStoryPointsAsc(Long productBacklogId);
}