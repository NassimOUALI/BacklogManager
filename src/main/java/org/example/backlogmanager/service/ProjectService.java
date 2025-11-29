package org.example.backlogmanager.service;

import org.example.backlogmanager.dto.ProjectCreateDTO;
import org.example.backlogmanager.model.Project;
import org.example.backlogmanager.model.ProductOwner;
import org.example.backlogmanager.repository.ProjectRepository;
import org.example.backlogmanager.repository.UserRepository; // Assuming you have this for PO
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    // CONSTRUCTOR INJECTION
    // This is the most important part for testability!
    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Project createProject(ProjectCreateDTO dto) {
        // 1. Validate DTO data
        if (dto.getNom() == null || dto.getNom().isEmpty()) {
            throw new IllegalArgumentException("Project name is required.");
        }

        // 2. Business Logic: Check Uniqueness
        // We call the interface method. We don't care that there is no implementation code yet.
        if (projectRepository.existsByName(dto.getNom())) {
            throw new IllegalStateException("A project with this name already exists.");
        }

        // 3. Business Logic: Validate Product Owner
        // In your UML, Project has 1 ProductOwner. We must find them first.
        ProductOwner po = (ProductOwner) userRepository.getById(dto.getProductOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Product Owner not found with ID: " + dto.getProductOwnerId()));



        // 4. Map DTO to Entity
        Project project = new Project();
        project.setNom(dto.getNom());
        project.setDescription(dto.getDescription());
        project.setDateDebut(dto.getDateDebut());
        project.setProductOwner(po); // Set the relationship

        // 5. Save via Interface
        return projectRepository.save(project);
    }
}