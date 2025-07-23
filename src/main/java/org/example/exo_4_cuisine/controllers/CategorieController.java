package org.example.exo_4_cuisine.controllers;

import org.example.exo_4_cuisine.interfaces.ICategorieService;
import org.example.exo_4_cuisine.model.Categorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategorieController {

    private final ICategorieService categorieService;

    public CategorieController(ICategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public String listCategories(Model model) {
        List<Categorie> categories = categorieService.getAllCategorie();
        model.addAttribute("categories", categories);
        return "categorie/categorieList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "categorie/categorieAdd";
    }

    @PostMapping("/add")
    public String addCategorie(@ModelAttribute Categorie categorie) {
        if (categorie != null)
            categorieService.createCategorie(categorie);
        return "redirect:/categories";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        Categorie categorie = categorieService.getCategorieById(id);
        model.addAttribute("categorie", categorie);
        return "categorie/categorieUpdate";
    }

    @PostMapping("/update")
    public String updateCategorie(@ModelAttribute Categorie categorie) {
        if (categorie.getId() != null)
            categorieService.updateCategorie(categorie.getId(), categorie);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable UUID id) {
        categorieService.deleteCategorieById(id);
        return "redirect:/categories";
    }
}
