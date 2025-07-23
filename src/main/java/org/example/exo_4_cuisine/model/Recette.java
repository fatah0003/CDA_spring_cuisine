package org.example.exo_4_cuisine.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String nom;
    @NotBlank
    private String ingredient;
    @NotBlank
    private String instruction;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;


}
