package com.devbeetrb.firstweek.lotto.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@NoArgsConstructor
public class Lotto {
    private Set<Integer> lottoNumbers = new TreeSet<>();

    public void createLottoNumber() {
        while (lottoNumbers.size() < 6) {
            Double lottoNumber = (Math.random() * 45) + 1;
            lottoNumbers.add(lottoNumber.intValue());
        }
    }
}
