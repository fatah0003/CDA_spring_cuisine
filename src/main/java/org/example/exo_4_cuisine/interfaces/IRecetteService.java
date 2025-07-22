package org.example.exo_4_cuisine.interfaces;

import org.example.exo_4_cuisine.model.Recette;

import java.util.List;
import java.util.UUID;

public interface IRecetteService {
    Recette createRecette(Recette recette);
    List<Recette> getAllRecette();
    Recette updateRecette(UUID id, Recette recette);
    void deleteRecetteById(UUID id);
    Recette getRecetteById(UUID id);
}
