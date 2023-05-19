package com.study.sidejavachallenge.dto.response;

import com.study.sidejavachallenge.entity.Student;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchResponseDto {

    private String name;
    private String title;

    public static SearchResponseDto mapToDto(Student student) {
        return SearchResponseDto.builder()
                .name(student.getName())
                .title(student.getTitle())
                .build();
    }
}
