// Dans src/main/java/org/example/backlogmanager/repository/AcceptanceCriteriaRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.AcceptanceCriteria;
import org.example.backlogmanager.entities.enums.Acceptance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcceptanceCriteriaRepository extends JpaRepository<AcceptanceCriteria, Long> {

    // --- Fonctions de Recherche par User Story ---

    /**
     * Trouve tous les critères d'acceptation associés à une User Story spécifique.
     * Cette méthode est essentielle pour afficher la définition de "Done" pour une US.
     */
    List<AcceptanceCriteria> findByUserStoryId(Long userStoryId);

    /**
     * Trouve tous les critères d'acceptation d'une User Story dans un état d'acceptation donné (Accepté/Refusé).
     * Permet de suivre l'avancement de la validation des critères.
     */
    List<AcceptanceCriteria> findByUserStoryIdAndAcceptance(Long userStoryId, Acceptance acceptance);
}