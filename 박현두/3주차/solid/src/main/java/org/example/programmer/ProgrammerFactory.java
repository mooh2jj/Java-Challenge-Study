package org.example.programmer;

import org.example.entity.MenuItem;

public class ProgrammerFactory {
    public Programmer recruitProgrammer(MenuItem menuItem) {
        if (menuItem.getLanguage().equalsIgnoreCase("자바")) {
            return new JavaProgrammer();
        } else if (menuItem.getLanguage().equalsIgnoreCase("C#")) {
            return new CSProgrammer();
        } else if (menuItem.getLanguage().equalsIgnoreCase("C")) {
            return new CProgrammer();
        } else if (menuItem.getLanguage().equalsIgnoreCase("Python")) {
            return new PythonProgrammer();
        } else {
            throw new IllegalStateException("해당 해당 언어는 지원하지 않습니다.");
        }
    }
}
