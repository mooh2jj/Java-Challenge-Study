package org.example.programmer;

import org.example.entity.MenuItem;
import org.example.entity.Program;

public class JavaProgrammer implements Programmer{

    private String language = "java";
    @Override
    public Program coding() {
        return new Program("웹사이트", "웹사이트", this.language);
    }

    @Override
    public String toString() {
        return "JavaProgrammer";
    }
}
