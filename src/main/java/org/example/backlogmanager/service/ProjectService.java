package org.example.backlogmanager.service;

import org.example.backlogmanager.dto.ProjectCreateDTO;
import org.example.backlogmanager.entities.Project;
import org.example.backlogmanager.entities.ProductOwner;
import org.example.backlogmanager.repository.ProjectRepository;
import org.example.backlogmanager.repository.UserRepository; // Assuming you have this for PO
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Project createProject(ProjectCreateDTO dto) {
        if (dto.getNom() == null || dto.getNom().isEmpty()) {
            throw new IllegalArgumentException("Project name is required.");
        }

        if (projectRepository.existsByName(dto.getNom())) {
            throw new IllegalStateException("A project with this name already exists.");
        }

        ProductOwner po = (ProductOwner) userRepository.findById(dto.getProductOwnerId())
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