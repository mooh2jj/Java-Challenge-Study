package JavaChallengeStudy.Hello.First;

import JavaChallengeStudy.Hello.First.Entity.Member;
import JavaChallengeStudy.Hello.First.dto.GradeDto;
import JavaChallengeStudy.Hello.First.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

//@Autowired
//@ToString
@Component
public class FirstServiceImpl implements FirstService {

    private FirstRepository firstRepository;

    @Autowired
    public FirstServiceImpl( FirstRepository firstRepository){
        this.firstRepository = firstRepository;
    }
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

        Member memberEntity = memberDto.
        firstRepository.save(memberDto);
        return null;
    }
//
//    // 스트림 적용 이전 코드
//    @Override
//    public List<Integer> lottoGenerator(int maxCount) {
//        if(maxCount<6){
//            //6보다 작은수가 오면 던져버린다.
//            return null;
//        }
//        Random lotto = new Random();
//        List<Integer> lottoList = new ArrayList<Integer>();
//        while (lottoList.size() < 6) {
//            //숫자뽑기
////            int tempNumber=(int)(Math.random()*45 +1);
//            int tempNumber = lotto.nextInt(maxCount) + 1; //1~maxCount
//            //중복체크
//            if (!lottoList.contains(tempNumber)) {
//                //번호 추가
//                lottoList.add(tempNumber);
//            }
//        }
//        return lottoList;
//    }

    @Override
    public List<Integer> lottoGenerator(int maxCount) {
        if(maxCount <6) return null; // 최소 자릿수 유효성검사. 더 좋방법이 있나? dto에서 하는게 더 좋나?
        return new Random().ints(1,maxCount+1)
                .distinct()  //중복제거 될때까지 반복.
                .limit(6) //리미티드 숫자만큼 안따라오면 다시 실행한다.
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public double calcGrade(List<GradeDto> grades) {
        List<Double> koreanScoreList = grades.stream().
                filter((grade)-> KoreanRegExp(grade.getSubjectName()))
                .map(GradeDto::getScore)
                .collect(Collectors.toList());
        int subjectCount = koreanScoreList.size();
        return koreanScoreList.stream().mapToDouble(i->i).sum() / koreanScoreList.size();

//        이전코드
//        int subjectCount =0;
//        //총 과목 성적 합.
//        double sumScore=0;
//        for(GradeDto grade : grades){
//            //한글이 들어가지 않은 과목.
//            if(!grade.getSubjectName().matches(regExp)){
//                break;
//            }
//            sumScore += grade.getScore();
//            subjectCount ++;
//        }
//        //평균 구하기.
//        return sumScore/subjectCount;
    }

    private boolean KoreanRegExp(String subjectName){
        return subjectName.matches("^[가-힣\\s]*$");

        //이전 코드
        //        String regExp = "^[가-힣\\s]*$";
        //        if(!subjectName.matches(regExp)){
//            return false;
//        }
//        return true;
    }
}
