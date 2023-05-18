package com.study.sidejavachallenge.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentRequestDto {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "과목을 입력해주세요.")
    private String title;

    @NotNull(message = "점수를 입력해주세요.")
    private Integer score;

    @Builder
    public StudentRequestDto(String name, String title, Integer score) {
        this.name = name;
        this.title = title;
        this.score = score;
    }

}
