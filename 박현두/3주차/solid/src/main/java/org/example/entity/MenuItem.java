package org.example.entity;

public class MenuItem {
    String type;
    String language;

    public MenuItem(String type, String language) {
        this.type = type;
        this.language = language;
    }

    public String getType() {
        return this.type;
    }

    public String getLanguage() {
        return this.language;
    }
}
