package com.study.side.dto;

import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
public class LottoInputDTO {

    public Set<Integer> lottoNumbers;

    public void setLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers);
        if(lottoNumbers.size() != 6) throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        if(lottoNumbers.size() != lottoNumbersSet.size()) throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        this.lottoNumbers = lottoNumbersSet;
    }
}
