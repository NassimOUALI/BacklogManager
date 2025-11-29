package org.example.backlogmanager.model;

import lombok.Getter;
import lombok.Setter;

public class ProductOwner extends User{
    @Getter
    @Setter
    private Long id;
    @Setter
    @Getter
    private String nom;
    @Setter
    @Getter
    private String prenom;

}
