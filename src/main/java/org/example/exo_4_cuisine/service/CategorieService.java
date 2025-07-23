package org.example.exo_4_cuisine.service;

import org.example.exo_4_cuisine.interfaces.ICategorieService;
import org.example.exo_4_cuisine.model.Categorie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CategorieService implements ICategorieService {

    private final Map<UUID, Categorie> categories = new HashMap<>();

    @Override
    public Categorie createCategorie(Categorie categorie) {
        categorie.setId(UUID.randomUUID());
        categories.put(categorie.getId(), categorie);
        return categorie;
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categories.values().stream().toList();
    }

    @Override
    public Categorie updateCategorie(UUID id, Categorie categorie) {
        Categorie categorieToUpdate = categories.get(id);
        if (categorieToUpdate == null)
            return null;

        if (!categorie.getNom().isBlank())
            categorieToUpdate.setNom(categorie.getNom());

        if (categorie.getDescription() != null && !categorie.getDescription().isBlank())
            categorieToUpdate.setDescription(categorie.getDescription());

        return categorieToUpdate;
    }

    @Override
    public void deleteCategorieById(UUID id) {
        categories.remove(id);
    }

    @Override
    public Categorie getCategorieById(UUID id) {
        return categories.get(id);
    }
}

