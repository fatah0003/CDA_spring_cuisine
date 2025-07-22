package org.example.exo_4_cuisine.controllers;

import org.example.exo_4_cuisine.interfaces.IRecetteService;
import org.example.exo_4_cuisine.model.Recette;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class RecetteController {
    private IRecetteService recetteService;

    public RecetteController(IRecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/add")
    public String addRecette(Model model){
        model.addAttribute("recette", new Recette());
        return "recette/add";
    }

    @PostMapping("/add")
    public String addRecette(Recette recette){
        if(recette != null)
            recetteService.createRecette(recette);
        System.out.println("ici");
        return "redirect:/list";
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
        return "recette/recetteList";
    }
}
