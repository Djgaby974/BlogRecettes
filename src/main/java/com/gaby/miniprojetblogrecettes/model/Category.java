package com.gaby.miniprojetblogrecettes.model;

public enum Category {
    ENTREE("Entrée"),
    PLAT("Plat principal"),
    DESSERT("Dessert"),
    BOISSON("Boisson");

    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}