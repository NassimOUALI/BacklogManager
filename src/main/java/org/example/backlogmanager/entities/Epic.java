package org.example.backlogmanager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Epic {
    @Id
    private Long id;

    @OneToMany(mappedBy = "epic")
    private List<UserStory> userStories;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ProductBacklog productBacklog;
}
