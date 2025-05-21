package com.gaby.miniprojetblogrecettes.repository;

import com.gaby.miniprojetblogrecettes.model.Comment;
import com.gaby.miniprojetblogrecettes.model.Recipe;
import com.gaby.miniprojetblogrecettes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRecipe(Recipe recipe);
    List<Comment> findByUser(User user);
    List<Comment> findByRecipeOrderByCreatedAtDesc(Long recipe);
    List<Comment> findTop10ByRecipeOrderByCreatedAtDesc(Recipe recipe);
    Long countByRecipe(Recipe recipe);
    List<Comment> findByRecipeId(Long recipeId);
    List<Comment> findByUserId(Long userId);

}