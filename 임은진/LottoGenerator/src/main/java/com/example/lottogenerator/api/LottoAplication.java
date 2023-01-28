package com.example.lottogenerator.api;

import com.example.lottogenerator.vo.LottoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class LottoAplication {

    @GetMapping("/lotto")
    @ResponseBody
    public List<LottoVO> lottoGenerater (int lotto_cnt){

        List<LottoVO> lottoVOs = new ArrayList<>(lotto_cnt);

        int loop = 1;

        while(loop<=lotto_cnt){
            LottoVO lottoVO = new LottoVO();
            int lotto[] = new int[6];

            lottoVO.setIdx(loop);

            for(int i=0; i<6; i++) {
                lotto[i] = (int)(Math.random() * 45) + 1;

                for(int j=0; j<i; j++) {
                    if(lotto[i] == lotto[j]) {
                        i--;
                        break;
                    }
                }
            }
            Arrays.sort(lotto);
            lottoVO.setLotto_num(lotto);
            lottoVOs.add(lottoVO);

            loop++;
        }
        return lottoVOs;
    }
}
