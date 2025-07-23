package org.example.exo_4_cuisine.controllers;

import org.example.exo_4_cuisine.interfaces.ICategorieService;
import org.example.exo_4_cuisine.interfaces.IRecetteService;
import org.example.exo_4_cuisine.model.Categorie;
import org.example.exo_4_cuisine.model.Recette;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class RecetteController {
    private IRecetteService recetteService;
    private final ICategorieService categorieService;

    public RecetteController(IRecetteService recetteService, ICategorieService categorieService) {
        this.recetteService = recetteService;
        this.categorieService = categorieService;
        }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/add")
    public String addRecette(Model model){
        model.addAttribute("recette", new Recette());
        model.addAttribute("categories", categorieService.getAllCategorie());
        return "recette/add";
    }

    @PostMapping("/add")
    public String addRecette(@ModelAttribute Recette recette,
                             @RequestParam("categorieId") UUID categorieId) {

        Categorie cat = categorieService.getCategorieById(categorieId); // méthode à avoir dans ton service
        recette.setCategorie(cat);

        recetteService.createRecette(recette); // ou addRecette() si c'est le nom chez toi
        return "redirect:/recette/list";
    }

    @GetMapping("/update/{id}")
    public String updateRecette(@PathVariable UUID id, Model model){
        Recette recette = recetteService.getRecetteById(id);
        model.addAttribute("recette", recette);
        return "recette/recetteUpdate";
    }


    @PostMapping("/update")
    public String updateRecette(Recette recette){
        if(recette.getId() != null)
            recetteService.updateRecette(recette.getId(), recette);

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deletRecette(@PathVariable UUID id){
        recetteService.deleteRecetteById(id);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String getAllRecettes(Model model){
        List<Recette> recettes = recetteService.getAllRecette();
        model.addAttribute("recettes", recettes);
        model.addAttribute("categories", categorieService.getAllCategorie());
        return "recette/recetteList";
    }
}
