package JavaChallengeStudy.Hello.First.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GradeDto {
    private String subjectName;
    private double score;
}
