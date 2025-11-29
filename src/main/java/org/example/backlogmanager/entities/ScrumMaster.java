package org.example.backlogmanager.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("SM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScrumMaster extends User{
}
