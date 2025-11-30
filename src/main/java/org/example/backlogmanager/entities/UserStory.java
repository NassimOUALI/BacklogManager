package org.example.backlogmanager.entities;
import jakarta.persistence.*;
import org.example.backlogmanager.entities.enums.MoscowPriority;
import org.example.backlogmanager.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;

    @ManyToOne
    @JoinColumn(name = "sprint_backlog_id")
    private SprintBacklog sprintBacklog;

    @ManyToOne
    @JoinColumn(name = "epic_id")
    private Epic epic;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private List<Task> tasks ;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private List<AcceptanceCriteria> acceptancenCriterias;

    //--------Valeur de logique de priorite--------

    @Enumerated(EnumType.STRING)
    private MoscowPriority moscowPriority; //la priorite de MoSCoW

    private int businessValue; // Valeur métier (ex: 1 à 100)
    private int storyPoints;   // Effort/Complexité (Fibonacci)

    // Pour WSJF (Time Criticality + Risk Reduction)
    private int timeCriticality;

    //---------------------------------------------
}
