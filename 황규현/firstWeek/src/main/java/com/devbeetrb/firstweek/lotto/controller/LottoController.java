package com.devbeetrb.firstweek.lotto.controller;

import com.devbeetrb.firstweek.lotto.persistence.Lotto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lotto")
public class LottoController {
    @PostMapping
    public Lotto createLottoNumber() {
        Lotto lotto = new Lotto();
        lotto.createLottoNumber();
        return lotto;
    }
}
