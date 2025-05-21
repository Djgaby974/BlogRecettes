package com.gaby.miniprojetblogrecettes.service;

import com.gaby.miniprojetblogrecettes.model.Comment;
import com.gaby.miniprojetblogrecettes.model.Recipe;
import com.gaby.miniprojetblogrecettes.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Commentaire non trouvé avec l'id: " + id));
    }

    public List<Comment> getCommentsByRecipe(Recipe recipe) {
        return commentRepository.findByRecipeOrderByCreatedAtDesc(recipe);
    }

    public Comment updateComment(Long id, Comment comment) {
        getCommentById(id); // Vérifie si le commentaire existe
        comment.setId(id);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}