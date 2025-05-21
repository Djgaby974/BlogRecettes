package com.gaby.miniprojetblogrecettes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le contenu du commentaire est obligatoire")
    @Size(min = 1, max = 1000, message = "Le commentaire doit contenir entre 1 et 1000 caractères")
    @Column(nullable = false, length = 1000)
    private String content;

    @NotNull(message = "L'utilisateur est obligatoire")
    @ManyToOne(optional = false)
    private User user;

    @NotNull(message = "La recette est obligatoire")
    @ManyToOne(optional = false)
    private Recipe recipe;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}