package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // --- Fonctions de Sécurité et d'Authentification ---

    // 1. Trouver un utilisateur par son email (essentiel pour la connexion, car l'email est unique)
    // Spring Security l'utilisera souvent pour charger les détails de l'utilisateur.
    Optional<User> findByEmail(String email);

    // 2. Vérifier si un email existe déjà lors de l'inscription
    boolean existsByEmail(String email);

    // --- Fonctions de Recherche Générale ---

    // 3. Trouver des utilisateurs par leur nom de famille
    List<User> findByLastName(String lastName);

    // 4. Trouver des utilisateurs par leur nom et prénom
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
}