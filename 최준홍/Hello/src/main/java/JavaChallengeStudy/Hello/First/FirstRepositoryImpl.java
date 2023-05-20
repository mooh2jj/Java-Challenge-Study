package JavaChallengeStudy.Hello.First;

import JavaChallengeStudy.Hello.First.Entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

public class FirstRepositoryImpl implements  FirstRepository{

    private final EntityManager entityManager;

    public FirstRepositoryImpl(EntityManager entityManager){
        this.entityManager=entityManager;

    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Member getName() {
        return null;
    }

    @Override
    public List<Member> getAllMember() {
        return null;
    }
}
