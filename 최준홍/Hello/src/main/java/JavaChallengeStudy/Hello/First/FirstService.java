package JavaChallengeStudy.Hello.First;

import JavaChallengeStudy.Hello.First.dto.GradeDto;
import JavaChallengeStudy.Hello.First.dto.MemberDto;

import java.util.List;

public interface FirstService {

    public List<String> deduplicationName(List<String> nameList);
    public  String convertHp(String hpList);

    public MemberDto addMember(MemberDto memberDto);

    public List<Integer> lottoGenerator(int maxCount);

    public double calcGrade(List<GradeDto> grades);

}
