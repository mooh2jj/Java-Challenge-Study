package JavaChallengeStudy.Hello.First.Entity;

import JavaChallengeStudy.Hello.First.dto.GradeDto;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "grade"
)
//    @ToString(exclude = {"comments", "tagBridges"})
@ToString
public class Grade {
    @Id
    private String Name;
    private String subjectName;
    private double score;

    //테스트를 위해서 생성자가 필요한 경우는?
    //entity <=> dto 좀 더 공부하기.
    @Builder
    public  Grade(String subjectName, double score){
        this.subjectName = subjectName;
        this.score =score;
    }

}
