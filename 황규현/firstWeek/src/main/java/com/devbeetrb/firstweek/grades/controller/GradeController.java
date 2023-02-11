package com.devbeetrb.firstweek.grades.controller;

import com.devbeetrb.firstweek.grades.interfaces.dtos.GradeResponseDto;
import com.devbeetrb.firstweek.grades.persistence.Grade;
import com.devbeetrb.firstweek.grades.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class GradeController {

    private GradeService gradeService;
    @GetMapping
    public GradeResponseDto createLottoNumber(@RequestBody Grade grade) {
        if(grade != null) {
            return null;
        }else{
            GradeResponseDto scoreAverageAndCount = GradeResponseDto.builder().build();
            boolean isKoreanSubjectName = Pattern.matches("^[가-힣]+$", grade.getSubjectName());
            if(isKoreanSubjectName) {
                scoreAverageAndCount = gradeService.getScoreAverageAndCount();
            }
            return scoreAverageAndCount;
        }
    }
}
