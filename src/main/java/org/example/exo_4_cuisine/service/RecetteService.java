package org.example.exo_4_cuisine.service;

import org.example.exo_4_cuisine.interfaces.IRecetteService;
import org.example.exo_4_cuisine.model.Recette;
import org.example.exo_4_cuisine.repository.RecetteRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RecetteService implements IRecetteService {

    public RecetteRepository recetteRepository;

    public RecetteService(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }

    @Override
    public Recette createRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    @Override
    public List<Recette> getAllRecette() {
        return recetteRepository.findAll();
    }

    @Override
    public Recette updateRecette(UUID id, Recette recette) {
        Recette recetteToUpdate = getRecetteById(recette.getId());
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

        return recetteRepository.save(recetteToUpdate);
    }

    @Override
    public void deleteRecetteById(UUID id) {
        recetteRepository.deleteById(id);
    }

    @Override
    public Recette getRecetteById(UUID id) {
        return recetteRepository.findById(id).orElse(null);
    }
}
