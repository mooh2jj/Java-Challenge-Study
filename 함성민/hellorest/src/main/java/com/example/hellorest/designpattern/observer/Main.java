package com.example.hellorest.designpattern.observer;

public class Main {
    public static void main(String[] args) {
        // 발행자 생성
        Baedi baedi = new Baedi();

        // 구독자 생성
        Crew josh = new Josh();
        Crew lewin = new Lewin();
        Crew tiber = new Tiber();

        baedi.subscribe(josh);
        baedi.subscribe(lewin);
        baedi.subscribe(tiber);

        baedi.upgradeCutie();
    }
}
