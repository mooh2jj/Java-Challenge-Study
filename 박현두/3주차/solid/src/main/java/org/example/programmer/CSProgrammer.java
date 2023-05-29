package org.example.programmer;

import org.example.entity.MenuItem;
import org.example.entity.Program;

public class CSProgrammer implements Programmer{

    private String language = "C#";
    @Override
    public Program coding() {
        return new Program("게임", "게임", this.language);
    }

    @Override
    public String toString() {
        return "CSProgrammer";
    }
}
