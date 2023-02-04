package com.devbeetrb.firstweek.grades.repository;

import com.devbeetrb.firstweek.grades.interfaces.dtos.GradeCategory;
import com.devbeetrb.firstweek.grades.interfaces.dtos.GradeResponseDto;

import com.devbeetrb.firstweek.grades.persistence.Grade;
import com.devbeetrb.firstweek.grades.persistence.QGrade;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.OptionalDouble;

@RequiredArgsConstructor
public class GradeCustomRepositoryImpl implements GradeCustomRepository{
    private final JPAQueryFactory queryFactory;
    QGrade grade = QGrade.grade;

    @Override
    public GradeResponseDto getSubjectsCountAndAverage() {
        List<Grade> gradeFetch = queryFactory.selectFrom(grade)
                .where(grade.category.eq(GradeCategory.KOREAN))
                .fetch();
        OptionalDouble average = gradeFetch.stream().mapToDouble(value -> value.getScore()).average();
        return GradeResponseDto.builder()
                .count(gradeFetch.size())
                .average(average!=null? average.getAsDouble() : 0.0)
                .build();
    }
}
