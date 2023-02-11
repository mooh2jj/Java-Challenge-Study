package com.example.hellorest.designpattern.observer;

public class Josh implements Crew{
    @Override
    public void update(String msg) {
        System.out.println("josh 수신 : " + msg);
    }
}
