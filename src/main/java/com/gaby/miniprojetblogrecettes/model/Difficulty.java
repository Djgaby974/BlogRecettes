package com.gaby.miniprojetblogrecettes.model;

public enum Difficulty {
    FACILE("Facile"),
    MOYEN("Moyen"),
    DIFFICILE("Difficile");

    private String displayName;

    Difficulty(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}