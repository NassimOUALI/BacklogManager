package org.example.backlogmanager.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductOwner productOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    private ScrumMaster scrumMaster;

    @ManyToMany
    @JoinTable(
            name = "project_developer",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private ArrayList<Developer> developers;

    private String nom;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductBacklog backlog;

    private LocalDate dateDebut;

}
