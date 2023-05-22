package com.study.sidejavachallenge.service;

import com.study.sidejavachallenge.dto.request.SearchRequestDto;
import com.study.sidejavachallenge.dto.request.StudentRequestDto;
import com.study.sidejavachallenge.dto.response.SearchResponseDto;
import com.study.sidejavachallenge.dto.response.StudentResponseDto;
import com.study.sidejavachallenge.entity.Student;
import com.study.sidejavachallenge.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    @Override
    public List<StudentResponseDto> getStudentAverage(List<StudentRequestDto> requestDto) {
        log.info("requestDTOs : {}", requestDto);

        int count = 0;
        int total = 0;
        double average = 0;

        Student student = Student.builder().build();  // 기본 초기값 설정
        Student saveStudent = null;

        for (StudentRequestDto request : requestDto) {
            count = (int) requestDto.stream()
                    .filter(a -> Student.isKorSubjectName(request.getTitle()))
                    .count();

            if (count > 0) {
                total = requestDto.stream()
                        .mapToInt(StudentRequestDto::getScore)
                        .sum();
                average = requestDto.stream()
                        .mapToInt(StudentRequestDto::getScore)
                        .average()
                        .getAsDouble();
            }

            student = Student.mapToEntity(request, count, total, average);
            log.info("mapToEntity student : {}", student);
            saveStudent = studentRepository.save(student);
        }

        List<StudentResponseDto> responseDtos = new ArrayList<>();
        responseDtos.add(StudentResponseDto.mapToDto(saveStudent));

        return responseDtos;
//        return List.of(StudentResponseDto.mapToDto(saveStudent));
    }

    @Override
    public List<SearchResponseDto> getStudentList(SearchRequestDto requestDto) {
        log.info("requestDto : {}", requestDto);
        List<Student> students = studentRepository.findSearch(requestDto.getName(), requestDto.getTitle());
        return students.stream()
                .map(SearchResponseDto::mapToDto)
                .collect(Collectors.toList());
    }


    /*
    @Transactional
    @Override
    public List<StudentResponseDto> getStudentAverage(List<StudentRequestDto> requestDTOs) {
        return requestDTOs.stream()
                .filter(subject -> Student.isKorSubjectName(subject.getTitle()))
                .map(subject -> {
                    int count = (int) requestDTOs.stream()
                            .filter(a -> Student.isKorSubjectName(subject.getTitle()))
                            .count();

                    int total = requestDTOs.stream()
                            .mapToInt(StudentRequestDto::getScore)
                            .sum();

                    double average = requestDTOs.stream()
                            .mapToInt(StudentRequestDto::getScore)
                            .average()
                            .getAsDouble();

                    Student student = mapToEntity(subject, count, total, average);
                    Student saveStudent = studentRepository.save(student);

                    return StudentResponseDto.mapToDto(saveStudent);
                })
                .distinct()
                .collect(Collectors.toList());
    }
    */
}
