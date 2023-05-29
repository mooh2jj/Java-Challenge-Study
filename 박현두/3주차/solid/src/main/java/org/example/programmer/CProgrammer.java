package org.example.programmer;

import org.example.entity.MenuItem;
import org.example.entity.Program;

public class CProgrammer implements Programmer{

    private String language = "C";

    @Override
    public Program coding() {
        return new Program("임베디드", "임베디드", this.language);
    }

    @Override
    public String toString() {
        return "CProgrammer";
    }
}
