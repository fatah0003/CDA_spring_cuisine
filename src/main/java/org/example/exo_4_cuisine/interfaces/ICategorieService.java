package org.example.exo_4_cuisine.interfaces;

import org.example.exo_4_cuisine.model.Categorie;
import org.example.exo_4_cuisine.model.Recette;

import java.util.List;
import java.util.UUID;

public interface ICategorieService {
    Categorie createCategorie(Categorie categorie);
    List<Categorie> getAllCategorie();
    Categorie updateCategorie(UUID id, Categorie categorie);
    void deleteCategorieById(UUID id);
}
