// Dans src/main/java/org/example/backlogmanager/repository/EpicRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpicRepository extends JpaRepository<Epic, Long> {

    // --- Fonctions de Gestion du Backlog ---

    /**
     * Trouve tous les Epics qui font partie d'un Product Backlog spécifique.
     * Essentiel pour la gestion des Epics et la visualisation des User Stories liées.
     * (Basé sur la relation ManyToOne avec ProductBacklog)
     */
    List<Epic> findByProductBacklogId(Long productBacklogId);

    // --- Fonctions de Recherche de Contenu ---

    /**
     * Pourrait inclure des méthodes pour compter les User Stories ou vérifier leur statut,
     * mais ces opérations sont souvent mieux gérées dans la couche Service en utilisant
     * le UserStoryRepository (ex: userStoryRepository.findByEpicId(epicId)).
     */
}