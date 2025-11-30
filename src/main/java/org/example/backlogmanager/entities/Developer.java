package org.example.backlogmanager.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("DEV")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Developer extends User{
    // Inverse side of the Many-to-Many defined in Project
    @ManyToMany(mappedBy = "developers")
    @ToString.Exclude
    private List<Project> projects;

    // A developer can have many assigned tasks
    @OneToMany(mappedBy = "assignedDeveloper")
    @ToString.Exclude
    private List<Task> tasks;
}
