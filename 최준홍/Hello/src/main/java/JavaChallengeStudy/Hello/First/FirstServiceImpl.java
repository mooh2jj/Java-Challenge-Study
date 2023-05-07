package JavaChallengeStudy.Hello.First;

import JavaChallengeStudy.Hello.First.dto.GradeDto;
import JavaChallengeStudy.Hello.First.dto.MemberDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

//@ToString
public class FirstServiceImpl implements FirstService {
    @Override
    public List<String> deduplicationName(List<String> nameList) {
        //HashSet은 List타입의 인자값을 받을 수 있는것 같다.
        // ??? : 다형성을 이용해서 ArrayList를 List로 리턴하게 되면 잘못되는건가?
        return new ArrayList<String>(new HashSet<String>(nameList));
    }

    @Override
    public String convertHp(String hpList) {
        return hpList.replaceAll("[-]", "");
    }

    @Override
    public MemberDto addMember(MemberDto memberDto) {
        return null;
    }

    @Override
    public List<Integer> lottoGenerator(int maxCount) {
        if(maxCount<6){
            //6보다 작은수가 오면 던져버린다.
            return null;
        }

        Random lotto = new Random();

        List<Integer> lottoList = new ArrayList<Integer>();
        while (lottoList.size() < 6) {
            //숫자뽑기
//            int tempNumber=(int)(Math.random()*45 +1);
            int tempNumber = lotto.nextInt(maxCount) + 1; //1~maxCount
            //중복체크
            if (!lottoList.contains(tempNumber)) {
                //번호 추가
                lottoList.add(tempNumber);
            }
        }

        return lottoList;
    }

    @Override
    public double calcGrade(List<GradeDto> grades) {
        String regExp = "^[가-힣\\s]*$";
        //총 과목수.
        int subjectCount =0;
        //총 과목 성적 합.
        double sumScore=0;
        for(GradeDto grade : grades){
            //한글이 들어가지 않은 과목.
            if(!grade.getSubjectName().matches(regExp)){
                break;
            }
            sumScore += grade.getScore();
            subjectCount ++;
        }
        //평균 구하기.
        return sumScore/subjectCount;
    }
}
