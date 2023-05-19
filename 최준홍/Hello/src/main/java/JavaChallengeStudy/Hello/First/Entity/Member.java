package JavaChallengeStudy.Hello.First.Entity;

import JavaChallengeStudy.Hello.First.dto.MemberDto;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;

//import javax.persistence.Entity;
//import javax.persistence.Table;

@Entity
//@Getter
////    @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "member"
)
//    @ToString(exclude = {"comments", "tagBridges"})
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String hpNumber;

    @Builder
    public Member(String name, String hpNumber){
        this.name = name;
        this.hpNumber = hpNumber;
    }

//    public static Member of(MemberDto memberDto){
//        return Member.builder()
//                .name(memberDto.getName())
//                .hpNumber(memberDto.getHpNumber())
//                .build();
//    }
//
//    public static Member from (MemberDto memberDto){
//        return MemberDto
//    }

}
