package com.example.hellorest.designpattern.singleton;

public class Singleton {
    private Singleton instance;

    private Singleton() {
    }

    // 방식 1
    public Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

//    // 방식 2
//    private static class Holder {
//        public static final Singleton INSTANCE = new Singleton();
//    }
//    public static Singleton getInstance() {
//        return Holder.INSTANCE;
//    }

}
