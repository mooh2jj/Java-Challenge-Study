package com.example.hellorest.designpattern.observer;

public interface Coach {
    //observable 발행자

    void subscribe(Crew crew);
    void unsubscribe(Crew crew);
    void notifyCrew(String msg);
}
