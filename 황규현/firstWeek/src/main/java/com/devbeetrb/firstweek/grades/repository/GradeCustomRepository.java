package com.devbeetrb.firstweek.grades.repository;

import com.devbeetrb.firstweek.grades.interfaces.dtos.GradeResponseDto;

public interface GradeCustomRepository {
    GradeResponseDto getSubjectsCountAndAverage();
}
