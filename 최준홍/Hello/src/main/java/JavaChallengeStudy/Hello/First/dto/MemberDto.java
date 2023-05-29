package JavaChallengeStudy.Hello.First.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data // data는 get, set, tostring, EqualsAndHashCode, RequiredArgsConstructor
public class MemberDto {
    private String name;
    private String hpNumber;
}
