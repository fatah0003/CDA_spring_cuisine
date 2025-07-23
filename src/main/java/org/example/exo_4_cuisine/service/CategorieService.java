package org.example.exo_4_cuisine.service;

import org.example.exo_4_cuisine.interfaces.ICategorieService;
import org.example.exo_4_cuisine.model.Categorie;
import org.example.exo_4_cuisine.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CategorieService implements ICategorieService {

    public CategoryRepository categoryRepository;

    public CategorieService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Categorie createCategorie(Categorie categorie) {
        return categoryRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categoryRepository.findAll();
    }

    @Override
    public Categorie updateCategorie(UUID id, Categorie categorie) {
        Categorie categorieToUpdate = getCategorieById(categorie.getId());
        if (categorieToUpdate == null)
            return null;

        if (!categorie.getNom().isBlank())
            categorieToUpdate.setNom(categorie.getNom());

        if (categorie.getDescription() != null && !categorie.getDescription().isBlank())
            categorieToUpdate.setDescription(categorie.getDescription());

        return categoryRepository.save(categorieToUpdate);
    }

    @Override
    public void deleteCategorieById(UUID id) {

        categoryRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorieById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }
}

