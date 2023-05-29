package JavaChallengeStudy.Hello.First.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class GradeDto {
    private String subjectName;
    private double score;
}
