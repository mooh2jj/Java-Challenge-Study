package org.example.client;

import org.example.config.CreateConfig;
import org.example.entity.*;
import org.example.programmer.Programmer;
import org.example.programmer.ProgrammerFactory;

public class Client{
    CreateConfig createConfig  = new CreateConfig();
    ProgrammerFactory factory = new ProgrammerFactory();
    Menu menu = new Menu(createConfig.items());
    public Program order(String programType){
        System.out.println("고객은 " + programType + "을 주문하였습니다.");
        MenuItem menuItem = menu.choose(programType);

        Programmer programmer = factory.recruitProgrammer(menuItem);
        System.out.println(programmer + "는 " + menuItem.getType() + " 주문을 받았습니다.");

        Program program = programmer.coding();
        System.out.println(programmer + "는 " + program.getName() + "을 만들었습니다.");

        System.out.println("고객은 주문한 " + menuItem.getType() + "을 받았습니다.");
        return program;
    }
}