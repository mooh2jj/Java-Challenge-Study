package org.example;

import org.example.client.Client;

public class Main {
    public static void main(String[] args) {
        try{
            Client client = new Client();
            client.order("게임");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}