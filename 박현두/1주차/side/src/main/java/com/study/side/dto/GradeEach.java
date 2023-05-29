package com.study.side.dto;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
public class GradeEach {

    private String subject;

    @NumberFormat
    private Integer score;

}
