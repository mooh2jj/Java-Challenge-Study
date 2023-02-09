package com.example.gradecal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue
    private int idx;
    private String studentName;
    private String subjectName;
    private double score;
}
