package JavaChallengeStudy.Hello.First;


import JavaChallengeStudy.Hello.First.Entity.Member;

import java.util.List;

public interface FirstRepository {
    public Member save(Member member);
    public Member getName();

    public List<Member> getAllMember();
}
