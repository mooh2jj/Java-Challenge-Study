package com.java.lotto.controller;

import com.java.lotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class LottoController {

    private final LottoService service;

    @GetMapping("/lotto/{cnt}")
    public List<Set<Integer>> getLotto(@PathVariable int cnt){
        List<Set<Integer>> result = new ArrayList<>();
        Set<Integer> lotto;

        for(int i=0; i<cnt; i++){
            lotto = service.getLotto();
            result.add(lotto);
        }

        return result;
    }
}
