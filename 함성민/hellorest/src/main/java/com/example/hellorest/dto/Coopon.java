package com.example.hellorest.dto;

import com.example.hellorest.service.CooponStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coopon {

    @NonNull
    String name;
    /* 등록날짜 */
    @JsonFormat(pattern = "yyyyMMdd")
    LocalDate beginDt;
    @JsonFormat(pattern = "yyyyMMdd")
    LocalDate endDt;
    CooponStatus cooponStatus;
}
