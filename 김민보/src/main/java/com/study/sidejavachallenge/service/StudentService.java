package com.study.sidejavachallenge.service;

import com.study.sidejavachallenge.dto.request.SearchRequestDto;
import com.study.sidejavachallenge.dto.request.StudentRequestDto;
import com.study.sidejavachallenge.dto.response.SearchResponseDto;
import com.study.sidejavachallenge.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {

    List<StudentResponseDto> getStudentAverage(List<StudentRequestDto> requestDto);

    List<SearchResponseDto> getStudentList(SearchRequestDto requestDto);
}
