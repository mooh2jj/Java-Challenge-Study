package com.example.hellorest.service;

import com.example.hellorest.dto.Coopon;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Service
public class CooponService {

    // 쿠폰 이름에 `한글` or `특수문자`가 포함되있는지 정규표현식으로 찾기
        public String nameCheck (Coopon coopon){
            String cooponName = coopon.getName();
            System.out.println(cooponName);
            // 한글
            //Pattern.matches("^[가-힣]*$",coopon.getName()); [가-힣]++
            // 특수문자
            //Pattern.matches("[!@#$%^&*(),.?\":{}|<>]",coopon.getName()); [!@#$%^&*(),.?\":{}|<>]++

//            if (Pattern.matches("^[가-힣]*$",cooponName)
//                    & Pattern.matches("[!@#$%^&*(),.?\":{}|<>]+",cooponName)){
//                return "한글, 특수문자가 모두 포함되어있습니다";
//            }else if (Pattern.matches("^[가-힣]$",cooponName)){
//                return "한글이 포함되어 있습니다.";
//            }else if (Pattern.matches("[!@#$%^&*(),.?\":{}|<>]",cooponName)){
//                return "특수문자가 포함되어 있습니다.";
//            }else
//                return "한글, 특수문자가 포함되어 있지 않습니다.";
//           (".*[!@#$%^&*(),.?\\\":{}|<>].*|.*[가-힣].*")
            boolean kor = Pattern.matches(".*[가-힣].*", cooponName);
            boolean special = Pattern.matches(".*[!@#$%^&*(),.?\\\":{}|<>].*",cooponName);
            System.out.println("kor : "+kor);
            System.out.println("special : "+special);

            if (kor && special){
                return "한글, 특수문자가 모두 포함되어있습니다.";
            }else if (kor){
                return "한글이 포함되어 있습니다.";
            }else if (special){
                return "특수문자가 포함되어 있습니다.";
            }else
                return "한글, 특수문자가 포함되어 있지 않습니다.";
        }

        public String cooponCheck(Coopon coopon){
//            LocalDate beginDt = dateToLocalDate(coopon.getBeginDt());
//            LocalDate endDt = dateToLocalDate(coopon.getEndDt());
            LocalDate beginDt = coopon.getBeginDt();
            LocalDate endDt = coopon.getEndDt();
            LocalDate nowDt = LocalDate.now();

            System.out.println("endDt.after.nowDt : " +
                    beginDt.minusDays(1).isBefore(nowDt)); // 현재가 시작일 뒤인가
            System.out.println("beginDt.after.nowDt : " +
                    endDt.plusDays(1).isAfter(nowDt)); // 현재가 종료일 전인가

            if (beginDt.minusDays(1).isBefore(nowDt)&
                    endDt.plusDays(1).isAfter(nowDt)){
                coopon.setCooponStatus(CooponStatus.ABLE);
            }else {
                coopon.setCooponStatus(CooponStatus.NUABLE);
            }

            return coopon.getCooponStatus().toString();
        }

//    public LocalDate dateToLocalDate (Date date){
//        return date.toInstant()   // Date -> Instant
//                .atZone(ZoneId.systemDefault())  // Instant -> ZonedDateTime
//                .toLocalDate();
//    }
}


