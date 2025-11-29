package org.example.backlogmanager.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Component
public class Project {

    @Setter
    @Getter
    private ProductOwner productOwner;

    @Setter
    @Getter
    private ScrumMaster scrumMaster;

    @Setter
    @Getter
    private ArrayList<Developer> developers;

    @Setter
    @Getter
    private String nom;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private ProductBacklog backlog;

    @Setter
    @Getter
    private LocalDate dateDebut;

}
