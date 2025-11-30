package org.example.backlogmanager.entities;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate dateDebut;

    @ManyToOne//many "Project" to one "productOwner" joined by the column product_owner_id
    @JoinColumn(name = "product_owner_id")
    private ProductOwner productOwner;

    @ManyToOne//many "Project" to one "scrumMaster" joined by the column scrum_master_id
    @JoinColumn(name = "scrum_master_id")
    private ScrumMaster scrumMaster;

    @ManyToMany//many "Project" to many "Developer" joined by a joined table called "project_developers" and by the column "project_id" from the project side and by the column "developer_id" from the developer side (it's gonna be filled by the @Id of each one)
    @JoinTable(
            name = "project_developers",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private List<Developer> developers;

    // Composition: Project "owns" the ProductBacklog
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductBacklog backlog;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Sprint> sprints;


}
