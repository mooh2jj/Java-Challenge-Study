package com.study.sidejavachallenge.repository;

import com.study.sidejavachallenge.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1% OR s.title LIKE %?2%")
    List<Student> findSearch(@Param("name") String name, @Param("title") String title);
}
