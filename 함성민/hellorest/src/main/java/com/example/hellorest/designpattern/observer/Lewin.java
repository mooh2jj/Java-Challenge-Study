package com.example.hellorest.designpattern.observer;

public class Lewin implements Crew{
    @Override
    public void update(String msg) {
        System.out.println("Lewin 수신 : " + msg);
    }
}
