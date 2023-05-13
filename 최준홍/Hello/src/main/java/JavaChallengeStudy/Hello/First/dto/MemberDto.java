package JavaChallengeStudy.Hello.First.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberDto {
    private String Name;
    private String HpNumber;

}
