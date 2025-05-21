package com.gaby.miniprojetblogrecettes.repository;

import com.gaby.miniprojetblogrecettes.model.Category;
import com.gaby.miniprojetblogrecettes.model.Difficulty;
import com.gaby.miniprojetblogrecettes.model.Recipe;
import com.gaby.miniprojetblogrecettes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory(Category category);
    List<Recipe> findByAuthor(User author);
    List<Recipe> findByTitleContainingIgnoreCase(String title);
    List<Recipe> findByCategoryOrderByCreatedAtDesc(Category category);
    List<Recipe> findAllByOrderByCreatedAtDesc();
    List<Recipe> findByDifficulty(Difficulty difficulty);
    List<Recipe> findByPreparationTimeLessThanEqual(Integer maxTime);
    List<Recipe> findTop5ByOrderByCreatedAtDesc();

}