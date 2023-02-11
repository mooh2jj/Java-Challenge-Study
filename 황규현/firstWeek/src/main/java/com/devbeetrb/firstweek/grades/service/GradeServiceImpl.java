package com.devbeetrb.firstweek.grades.service;

import com.devbeetrb.firstweek.grades.interfaces.dtos.GradeResponseDto;
import com.devbeetrb.firstweek.grades.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService{

    private GradeRepository gradeRepository;

    @Override
    public GradeResponseDto getScoreAverageAndCount() {
        return gradeRepository.getSubjectsCountAndAverage();
    }
}
