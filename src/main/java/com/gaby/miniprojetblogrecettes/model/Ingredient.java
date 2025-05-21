package com.gaby.miniprojetblogrecettes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'ingrédient est obligatoire")
    @Column(nullable = false)
    private String name;

    @Positive(message = "La quantité doit être positive")
    private Double quantity;

    private String unit;

    @ManyToOne
    private Recipe recipe;
}