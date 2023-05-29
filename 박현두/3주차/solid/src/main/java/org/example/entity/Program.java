package org.example.entity;

public class Program{
    String name;
    String description;
    String language;

    public Program(String name, String description, String language){
        this.name = name;
        this.description = description;
        this.language = language;
    }

    public String getName() {
        return name;
    }
}