package com.example.lottogenerator.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ScoreVO {
    String subject;
    double Score;

    private List<ScoreVO> list;
}
