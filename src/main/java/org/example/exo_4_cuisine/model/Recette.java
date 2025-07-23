package org.example.exo_4_cuisine.model;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recette {
    private UUID id;
    private String nom;
    private String ingredient;
    private String instruction;
    private Categorie categorie;

}
