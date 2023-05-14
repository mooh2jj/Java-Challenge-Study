package com.study.side.service;

import com.study.side.dto.LottoOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class LottoService {

    public LottoOutputDTO isWin(Set<Integer> inputLottoNumbers) {
        Set<Integer> outputNumbers = getLottoNumbers().boxed().collect(Collectors.toSet());

        return LottoOutputDTO.builder()
                .isWin(inputLottoNumbers.equals(outputNumbers))
                .outputLottoNumbers(outputNumbers)
                .build();
    }

    private IntStream getLottoNumbers() {
        Random random = new Random();
        return random.ints(1, 46)
                .distinct()
                .limit(6)
                .sorted();
    }
}
