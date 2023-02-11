package com.example.hellorest.service;

import com.example.hellorest.dto.Lotto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LottoService {

    public String playLotto(Lotto lotto){
        System.out.println("Lotto Service init");
        System.out.println("my number :" + Arrays.toString(lotto.getLotto()));

        //기본 6개의 번호
        Set<Integer> set = new HashSet<>();

        //answer 당첨번호 만들기 1~45 중복x 6개 기본번호, 마지막 보너스번호
        while (set.size() < 7){
            Integer lucky = (int) (Math.random() * 45)+1;
            System.out.println(lucky);
            set.add(lucky);
        }
        System.out.println("Lotto create!");
        //list로 만들고
        List<Integer> answer = new ArrayList<>(set);

        System.out.println("Lotto answer : " + answer.toString());

        int cnt = 0;
        int Bcnt = 0;
        //추첨
        for (int i = 0; i < lotto.getLotto().length; i++){
            for (int j =0; j<answer.size(); j++){

                //내 번호와 당첨번호가 같다면
                if (lotto.getLotto()[i] == answer.get(j)){
                    // 마지막번호(보너스번호)라면
                    if (j == answer.size()){
                        Bcnt ++;
                    }else {
                        cnt++;
                    }
                }
            }
        }

        String print = answer.toString();
        String lucky;
        if (cnt == 6){
            lucky = "1등 당첨!! 20억!!";
        }else if (cnt == 5 & Bcnt == 1){
            lucky = "2등 당첨!! 5천만원!!";
        }else if ((cnt+Bcnt) == 5 ) {
            lucky = "3등 당첨!! 150만원!!";
        }else if ((cnt+Bcnt) == 4){
            lucky ="4등 당첨!! 5만원!";
        }else if ((cnt+Bcnt) == 3){
            lucky ="5등 당첨!! 5천원!";
        }else
            lucky ="다음 기회에";

        return "당첨번호 : " + print + "\n" +
                "추첨결과 " + (cnt+Bcnt) +"개 일치 \n"
                + lucky;
    }
}
