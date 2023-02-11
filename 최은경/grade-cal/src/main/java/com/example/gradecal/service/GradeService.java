package com.example.gradecal.service;

import com.example.gradecal.entity.Grade;

import java.util.List;

public interface GradeService {
    String calGrade(List<Grade> grades);
}
