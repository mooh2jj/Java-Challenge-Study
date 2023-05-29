package org.example.config;

import org.example.entity.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CreateConfig {
    List<MenuItem> items = new ArrayList<>();

    public List<MenuItem> items() {
        items.add(new MenuItem("게임", "C#"));
        items.add(new MenuItem("웹사이트", "자바"));
        items.add(new MenuItem("머신러닝", "파이썬"));
        items.add(new MenuItem("임베디드", "C"));
        return items;
    }

}
