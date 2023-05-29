package com.study.sidejavachallenge.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import com.study.sidejavachallenge.dto.request.StudentRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.regex.Pattern;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "students")
public class Student extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private int score;

    private int count;
    private int total;
    private double average;

    @Builder
    public Student(Long id,
                   String name,
                   String title,
                   int score,
                   int count,
                   int total,
                   double average) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.score = score;
        this.count = count;
        this.total = total;
        this.average = average;
    }

    /*
    public double calculateAverage(List<SubjectRequestDto> subjects) {
        return subjects.stream()
                .filter(subject -> isKorSubjectName(subject.getTitle()))
                .mapToInt(SubjectRequestDto::getScore)
                .average()
                .getAsDouble();
    }
    */

    public static boolean isKorSubjectName(String str) {
        return Pattern.compile("^[ㄱ-ㅎ가-힣]*$").matcher(str).matches();

    }

    public static Student mapToEntity(StudentRequestDto subject, int count, int total, double average) {
        return Student.builder()
                .name(subject.getName())
                .title(subject.getTitle())
                .score(subject.getScore())
                .count(count)
                .total(total)
                .average(average)
                .build();
    }
}
