package JavaChallengeStudy.Hello.First.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GradeDto {
    private String subjectName;
    private double score;

    //테스트를 위해서 생성자가 필요한 경우는?
    //entity <=> dto 좀 더 공부하기.
    public  GradeDto(String subjectName, double score){
        this.subjectName = subjectName;
        this.score =score;
    }
}
