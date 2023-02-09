package com.example.gradecal.repository;

import com.example.gradecal.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @Query(value = "SELECT sum(score) FROM grade WHERE student_name = :studentName and subject_name regexp '^[가-힇]+$'",
            nativeQuery = true)
    Double sumOfScoreByStudentNameAndSubjectNameInKorean(@Param("studentName") String studentName);

    @Query(value = "SELECT COUNT(*) FROM grade WHERE student_name = :studentName and subject_name regexp '^[가-힇]+$'",
            nativeQuery = true)
    int countByStudentNameAndSubjectNameInKorean(@Param("studentName") String studentName);
}
