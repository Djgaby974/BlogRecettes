package com.gaby.miniprojetblogrecettes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Recipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    @Size(min = 3, max = 100, message = "Le titre doit contenir entre 3 et 100 caractères")
    @Column(nullable = false)
    private String title;

    @Size(max = 2000, message = "La description ne peut pas dépasser 2000 caractères")
    @Column(length = 2000)
    private String description;

    @NotNull(message = "La catégorie est obligatoire")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Positive(message = "Le temps de préparation doit être positif")
    private Integer preparationTime;

    @PositiveOrZero(message = "Le temps de cuisson doit être positif ou nul")
    private Integer cookingTime;

    @Min(value = 1, message = "Le nombre de portions doit être d'au moins 1")
    private Integer servings;

    @NotNull(message = "La difficulté est obligatoire")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    @NotEmpty(message = "Les instructions sont obligatoires")
    @Size(max = 3000, message = "Les instructions ne peuvent pas dépasser 3000 caractères")
    @Column(length = 3000)
    private String instructions;

    private String imageUrl;

    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}