package net.supervision.devoirdatarest.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Centre {
    @Id
    private Long id;
    private String nom;
    private String adresse;
    @OneToMany(mappedBy = "centre", fetch = FetchType.EAGER)
    private List<Etudiant> etudiants;

}
