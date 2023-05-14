package first.firststudy.service;

import first.firststudy.dto.LottoDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LottoService {
    public List<LottoDto> createLottos(int count) {
        List<LottoDto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = createLottoNumbers();
            LottoDto lotto = new LottoDto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int number = (int) (Math.random() * 45) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        Collections.sort(numbers);
        return numbers;
    }
}
