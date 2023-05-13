package com.study.side.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class SubjectStatisticsDTO {

    private int count;

    private float average;

    @Builder
    public SubjectStatisticsDTO(int count, float average) {
        this.count = count;
        this.average = average;
    }
}
