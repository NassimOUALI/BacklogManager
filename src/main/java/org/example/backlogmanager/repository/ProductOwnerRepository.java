// Dans src/main/java/org/example/backlogmanager/repository/ProductOwnerRepository.java

package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOwnerRepository extends JpaRepository<ProductOwner, Long> {

    // --- Fonctions Spécifiques au Rôle ---

    /**
     * Trouve tous les Product Owners qui gèrent un projet spécifique.
     * Cette méthode repose sur la relation 'ownedProjects' et l'ID du projet.
     */
    ProductOwner findByOwnedProjects_Id(Long projectId);

    // Les méthodes findByEmail ou findByLastName sont héritées du UserRepository.
}