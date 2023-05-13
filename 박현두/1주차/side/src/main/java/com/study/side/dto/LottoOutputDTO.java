package com.study.side.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@Data
public class LottoOutputDTO {

    private boolean isWin;

    Set<Integer> outputLottoNumbers;

    @Builder
    public LottoOutputDTO(boolean isWin, Set<Integer> outputLottoNumbers) {
        this.isWin = isWin;
        this.outputLottoNumbers = outputLottoNumbers;
    }
}
