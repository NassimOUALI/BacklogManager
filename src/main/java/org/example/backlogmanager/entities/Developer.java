package org.example.backlogmanager.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("DEV")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Developer extends User{
    @ManyToMany(mappedBy = "Project")
    List<Project> projects;
}
