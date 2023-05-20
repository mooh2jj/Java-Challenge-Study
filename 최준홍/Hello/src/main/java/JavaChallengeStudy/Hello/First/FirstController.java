package JavaChallengeStudy.Hello.First;

import JavaChallengeStudy.Hello.First.dto.GradeDto;
import JavaChallengeStudy.Hello.First.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FirstController {


    private FirstService firstService;

    public FirstController(FirstService firstService) {
        this.firstService = new FirstServiceImpl();
    }

    @PostMapping("deduplication-name")
    public List<String> setName(@RequestBody ArrayList<String> nameList) {
        return firstService.deduplicationName(nameList);
    }

    @GetMapping("convert-hp")
    public String convertHp(@RequestParam String hp) {
        return firstService.convertHp(hp);
    }


    @PostMapping("member")
    public MemberDto member(@RequestBody MemberDto memberDto) {
//        MemberDto request = MemberDto.builder()
//                .Name(memberDto.getName())
//                .HpNumber(memberDto.getHpNumber())
//                .build();

        return firstService.addMember(memberDto);
    }

    @PostMapping("calc-grade")
    public double calcGrade(@RequestBody List<GradeDto> grade) {
        return firstService.calcGrade(grade);
    }

}
