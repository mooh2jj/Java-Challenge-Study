package org.example.programmer;

import org.example.entity.Program;

public class PythonProgrammer implements Programmer{

    private String language = "Python";
    @Override
    public Program coding() {
        return new Program("머신러닝", "머신러닝", this.language);
    }

    @Override
    public String toString() {
        return "PythonProgrammer";
    }
}
