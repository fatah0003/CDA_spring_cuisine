package org.example.exo_4_cuisine.service;

import org.example.exo_4_cuisine.interfaces.IRecetteService;
import org.example.exo_4_cuisine.model.Recette;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RecetteService implements IRecetteService {

    private final Map<UUID, Recette> recettes = new HashMap<>();

    @Override
    public Recette createRecette(Recette recette) {
        recette.setId(UUID.randomUUID());
        recettes.put(recette.getId(), recette);
        return recette;
    }


    @Override
    public List<Recette> getAllRecette() {
        return recettes.values().stream().toList();
    }

    @Override
    public Recette updateRecette(UUID id, Recette recette) {
        Recette recetteToUpdate = recettes.get(id);
        if(recetteToUpdate == null)
            return null;

        if(!recette.getNom().isBlank())
            recetteToUpdate.setNom(recette.getNom());

        if(recette.getCategorie() != null)
            recetteToUpdate.setCategorie(recette.getCategorie());

        if(!recette.getInstruction().isBlank())
            recetteToUpdate.setInstruction(recette.getInstruction());

        if(!recette.getIngredient().isBlank())
            recetteToUpdate.setIngredient(recette.getIngredient());

        return recetteToUpdate;
    }

    @Override
    public void deleteRecetteById(UUID id) {
        recettes.remove(id);
    }

    @Override
    public Recette getRecetteById(UUID id) {
        return recettes.get(id);
    }
}
