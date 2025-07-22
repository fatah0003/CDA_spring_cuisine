package org.example.exo_4_cuisine.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categorie {
    private UUID id;
    private String nom;
    private String description;
}
