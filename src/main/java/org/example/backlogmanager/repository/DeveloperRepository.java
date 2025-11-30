// Dans src/main/java/org/example/backlogmanager/repository/DeveloperRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    // --- Fonctions de Gestion d'Équipe et d'Affectation ---

    /**
     * Trouve tous les développeurs affectés à un projet spécifique.
     * Cette méthode est essentielle pour lister l'équipe de développement d'un projet.
     * Repose sur la relation Many-to-Many (projects) définie dans Developer.
     */
    List<Developer> findByProjectsId(Long projectId);

    /**
     * Trouve tous les développeurs qui n'ont aucune tâche en cours.
     * (Bien que complexe pour une Query Method simple, elle illustre l'intention)
     * Une implémentation plus propre pourrait nécessiter une requête @Query personnalisée.
     */
    // List<Developer> findByTasksIsEmpty(); 

    // Les méthodes findByEmail ou findByLastName sont héritées du UserRepository.
}