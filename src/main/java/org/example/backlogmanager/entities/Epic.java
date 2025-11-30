package org.example.backlogmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
}
