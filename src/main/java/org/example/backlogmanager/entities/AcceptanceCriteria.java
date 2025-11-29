package org.example.backlogmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backlogmanager.entities.enums.Acceptance;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcceptanceCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Acceptance acceptance;
    private String description;

    @ManyToOne
    private UserStory userStory;
}
