package com.java.lotto.service.impl;

import com.java.lotto.service.LottoService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LottoServiceImpl implements LottoService {
    @Override
    public Set<Integer> getLotto() {
        Set<Integer> result = new HashSet<>();
        Random random = new Random();
        int randomNum;
        while(result.size() < 6){
            randomNum = random.nextInt(45)+1;
            result.add(randomNum);
        }
        return result;
    }
}
