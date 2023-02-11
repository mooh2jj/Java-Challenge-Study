package com.example.hellorest.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Baedi implements Coach{
    private List<Crew> crews = new ArrayList<>();

    public void eatFood() {
        System.out.println("베디코치가 밥을 먹는다");
        notifyCrew("나 밥 먹었다");
    }

    public void runaway() {
        System.out.println("베디코치가 농땡이를 친다");
        notifyCrew("나 농땡이 쳤다");
    }

    public void upgradeCutie() {
        System.out.println("베디코치가 귀여움을 강화했다");
        notifyCrew("나 더 귀여워 졌다");
    }

    @Override
    public void notifyCrew(String msg) {
        // 배열을 순회하며 update 실행
       crews.forEach(crew -> crew.update(msg));
    }

    @Override
    public void subscribe(Crew crew) {
        crews.add(crew);
    }

    @Override
    public void unsubscribe(Crew crew) {
        crews.remove(crew);
    }
}
