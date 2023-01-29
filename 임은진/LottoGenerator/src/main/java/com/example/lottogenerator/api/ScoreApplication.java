package com.example.lottogenerator.api;

import com.example.lottogenerator.vo.ScoreVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
public class ScoreApplication {

    @PostMapping("avg_calculate")
    @ResponseBody
    public Map avgCalculate (@RequestBody ScoreVO param){

        Map result = new HashMap();

        int cnt = 0;
        double sum = 0;
        double avg;

        for (int i=0; i<param.getList().size(); i++){
            ScoreVO scoreVO = param.getList().get(i);
            if(isKorChar(scoreVO.getSubject())){
                sum += scoreVO.getScore();
                cnt++;
            }
        }
        avg =  (Double) sum/cnt;

        result.put("합계", sum);
        result.put("평균", avg);
        result.put("과목수", cnt);

        return result;
    }

    public static boolean isKorChar(String subject) {
        return Pattern.matches("^[가-힣]*$", subject);
    }

}
