package org.example.backlogmanager.repository;

import org.example.backlogmanager.entities.ScrumMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScrumMasterRepository extends JpaRepository<ScrumMaster, Long> {

    // Méthodes héritées du UserRepository et spécifiques au rôle

    // Ajoutez ici des Query Methods spécifiques au Scrum Master si nécessaire (ex: si l'entité ScrumMaster
    // contenait des champs spécifiques à interroger, ou si vous vouliez trouver par projet facilité, etc.)
    // Par défaut, l'héritage de JpaRepository et les méthodes findByEmail du UserRepository sont suffisantes.
}