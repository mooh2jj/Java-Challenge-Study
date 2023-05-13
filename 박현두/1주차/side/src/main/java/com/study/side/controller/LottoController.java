package com.study.side.controller;

import com.study.side.dto.LottoInputDTO;
import com.study.side.dto.LottoOutputDTO;
import com.study.side.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lotto")
@RequiredArgsConstructor
public class LottoController {

    private final LottoService lottoService;

    @PostMapping
    public LottoOutputDTO lotto(@RequestBody LottoInputDTO lotto) {
        return lottoService.isWin(lotto.getLottoNumbers());
    }

}
