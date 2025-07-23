package org.example.exo_4_cuisine.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nom;
    private String ingredient;
    private String instruction;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;


}
