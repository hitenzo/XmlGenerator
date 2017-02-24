package com.company;
import py4j.GatewayServer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        // app is now the gateway.entry_point
        GatewayServer server = new GatewayServer(app);
        server.start();
    }

    public String getSourceXml(int count){
        //generate main node <source>
        //generate single node <information>
        //fill information with proper nodes and values to it (getLogin)
        //create xml, parse it to string and return

        return "hello";
    }

    private String getLogin(){
        String login = "";
        Random rand = new Random();

        for(int i=0; i<8; i++){
            char randomCharacter = (char)(rand.nextInt(26) + 'a');
            login = login.concat(Character.toString(randomCharacter));
        }

        for(int j=0; j<5; j++){
            int randomNumber = rand.nextInt(10);
            login = login.concat(Integer.toString(randomNumber));
        }

        return login;
    }
}
