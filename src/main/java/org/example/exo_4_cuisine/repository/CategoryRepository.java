package org.example.exo_4_cuisine.repository;

import org.example.exo_4_cuisine.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Categorie, UUID> {
}
