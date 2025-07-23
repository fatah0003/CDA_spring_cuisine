package org.example.exo_4_cuisine.repository;

import org.example.exo_4_cuisine.model.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecetteRepository extends JpaRepository<Recette, UUID> {
}
