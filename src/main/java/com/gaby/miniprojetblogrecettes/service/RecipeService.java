package com.gaby.miniprojetblogrecettes.service;

import com.gaby.miniprojetblogrecettes.model.Category;
import com.gaby.miniprojetblogrecettes.model.Recipe;
import com.gaby.miniprojetblogrecettes.model.User;
import com.gaby.miniprojetblogrecettes.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recette non trouvée avec l'id: " + id));
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getRecipesByCategory(Category category) {
        return recipeRepository.findByCategory(category);
    }

    public List<Recipe> getRecipesByAuthor(User author) {
        return recipeRepository.findByAuthor(author);
    }

    public Recipe updateRecipe(Long id, Recipe recipe) {
        getRecipeById(id); // Vérifie si la recette existe
        recipe.setId(id);
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> searchRecipesByTitle(String title) {
        return List.of();
    }
}