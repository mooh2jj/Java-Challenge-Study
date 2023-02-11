package com.example.gradecal.controller;

import com.example.gradecal.entity.Grade;
import com.example.gradecal.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GradeController {
    private final GradeService service;

    @PostMapping("/grade")
    public String calGrade(@RequestBody List<Grade> grades){
        return service.calGrade(grades);
    }
}
