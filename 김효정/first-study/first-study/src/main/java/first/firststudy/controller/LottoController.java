package first.firststudy.controller;

import first.firststudy.dto.LottoDto;
import first.firststudy.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotto")
public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @PostMapping("/{count}")
    public List<LottoDto> createLottos(@PathVariable int count) {
        return lottoService.createLottos(count);
    }
}


