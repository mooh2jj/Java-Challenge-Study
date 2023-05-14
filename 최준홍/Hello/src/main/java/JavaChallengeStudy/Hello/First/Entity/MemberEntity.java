package JavaChallengeStudy.Hello.First.Entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "member"
)
//    @ToString(exclude = {"comments", "tagBridges"})
@ToString
public class MemberEntity {
    private String Name;
    private String HpNumber;
}
