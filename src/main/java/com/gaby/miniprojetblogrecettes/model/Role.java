package com.gaby.miniprojetblogrecettes.model;

public enum Role {
    USER("Utilisateur"),
    ADMIN("Administrateur");

    private String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}