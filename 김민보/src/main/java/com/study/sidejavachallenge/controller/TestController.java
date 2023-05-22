package com.study.sidejavachallenge.controller;

import com.study.sidejavachallenge.dto.request.SearchRequestDto;
import com.study.sidejavachallenge.dto.request.LottoRequestDto;
import com.study.sidejavachallenge.dto.request.StudentRequestDto;
import com.study.sidejavachallenge.dto.response.SearchResponseDto;
import com.study.sidejavachallenge.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final StudentService studentService;

    @GetMapping("/test")
    public List<String> test() {

        List<String> list = new ArrayList<>();
        list.add("dsg");
        list.add("dsg");
        list.add("kmb");
        list.add("hgd");

        log.info("list : {}", list);

        return list;
    }

    @GetMapping("/test2")
    public String test2() {

        List<String> list = new ArrayList<>();
        list.add("dsg");
        list.add("dsg");
        list.add("kmb");
        list.add("hgd");

//        String result = "";
        StringBuilder sb = new StringBuilder();

        for(String str : list) {
            log.info("str : {}", str);
            sb.append(str);
            sb.append(", ");
        }

        return sb.toString();
    }

    @GetMapping("/test3")
    public String test3() {

        String number = "010-1111-2222";
        log.info("number: {}", number);
        return number.replaceAll("-", "");
    }

    // 로또 생성기
    @PostMapping("/test4")
    public List<Integer> test4(@RequestBody LottoRequestDto request) {

        int numberCount = request.getNum();
        log.info("numberCount : {}", numberCount);  // 6

        Random random = new Random();
        List<Integer> lottoNumber = new ArrayList<>();
        log.info("lottoNumber : {}", lottoNumber);

        while (lottoNumber.size() < numberCount) {
            int randomNumber = random.nextInt(45) + 1;
            log.info("randomNumber : {}", randomNumber);

            if(!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber);
            }
        }

        return lottoNumber;
    }

    // 학생 이름, 과목, 성적 입력  ==>  평균 출력
    @PostMapping("/test5")
    public ResponseEntity<?> test5(
            @Valid @RequestBody List<StudentRequestDto> requestDTOs
    ) {
        return new ResponseEntity<>(studentService.getStudentAverage(requestDTOs), HttpStatus.CREATED);
    }

    // search list
    @GetMapping("/test6")
    public ResponseEntity<?> test6(
       SearchRequestDto requestDto
    ) {
        List<SearchResponseDto> list = studentService.getStudentList(requestDto);
        log.info("list : {}", list);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
