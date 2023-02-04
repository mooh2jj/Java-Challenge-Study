package com.devbeetrb.firstweek.grades.service;

import com.devbeetrb.firstweek.grades.interfaces.dtos.GradeResponseDto;

public interface GradeService {
    GradeResponseDto getScoreAverageAndCount();
}
