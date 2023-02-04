package com.devbeetrb.firstweek.grades.repository;

import com.devbeetrb.firstweek.grades.persistence.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long>, GradeCustomRepository {
}
