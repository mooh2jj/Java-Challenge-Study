package org.example.entity;

import java.util.List;

public class Menu {
    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    List<MenuItem> menuItems;

    public MenuItem choose(String programType){
        return menuItems.stream().filter(menuItem -> menuItem.getType().equals(programType)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 프로그램은 개발할 수 없습니다."));
    }
}
