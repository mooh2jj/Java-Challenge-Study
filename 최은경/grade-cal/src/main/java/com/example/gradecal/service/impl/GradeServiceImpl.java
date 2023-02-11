package com.example.gradecal.service.impl;

import com.example.gradecal.entity.Grade;
import com.example.gradecal.repository.GradeRepository;
import com.example.gradecal.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository repository;


    @Override
    public String calGrade(List<Grade> grades) {
        repository.saveAll(grades);
        StringBuilder sb = new StringBuilder();

        int cnt = repository.countByStudentNameAndSubjectNameInKorean(grades.get(0).getStudentName());
        double sum = repository.sumOfScoreByStudentNameAndSubjectNameInKorean(grades.get(0).getStudentName());

        sb.append("한글 이름의 과목은 총 " + cnt + "개 이고, \n");
        sb.append("한글 이름의 과목 평균 점수는 " + (sum / cnt) +"점입니다.");
        return String.valueOf(sb);
    }


}
