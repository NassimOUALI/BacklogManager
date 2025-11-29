package org.example.backlogmanager.entities;
import jakarta.persistence.*;
import org.example.backlogmanager.entities.enums.MoscowPriority;
import org.example.backlogmanager.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    private AcceptanceCriteria acceptancenCriteria;

    //--------Valeur de logique de priorite--------

    private MoscowPriority moscowPriority; //la priorite de MoSCoW

    private int businessValue; // Valeur métier (ex: 1 à 100)
    private int storyPoints;   // Effort/Complexité (Fibonacci)

    // Pour WSJF (Time Criticality + Risk Reduction)
    private int timeCriticality;

    //---------------------------------------------
}
