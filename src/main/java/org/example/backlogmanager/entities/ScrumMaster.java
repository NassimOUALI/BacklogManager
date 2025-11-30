package org.example.backlogmanager.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("SM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrumMaster extends User{
    @OneToMany(mappedBy = "scrumMaster")
    @ToString.Exclude
    private List<Project> facilitatedProjects;
}
