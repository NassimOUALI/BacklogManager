package org.example.backlogmanager.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.backlogmanager.entities.enums.Status;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_story_id")
    private UserStory userStory;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer assignedDeveloper;


}
