package org.example.backlogmanager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("PO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductOwner extends User{

    @OneToMany(mappedBy = "productOwner", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Project> ownedProjects;

}
