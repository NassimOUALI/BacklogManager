package org.example.backlogmanager.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.backlogmanager.model.ProductBacklog;

import java.time.LocalDate;

public class ProjectCreateDTO {
    @Getter
    @Setter
    private String nom;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private LocalDate dateDebut;
    @Setter
    @Getter
    private Long productOwnerId;
    @Getter
    @Setter
    private ProductBacklog productBacklog;

}
