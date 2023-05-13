package JavaChallengeStudy.Hello;

import JavaChallengeStudy.Hello.First.FirstService;
import JavaChallengeStudy.Hello.First.FirstServiceImpl;
import JavaChallengeStudy.Hello.First.dto.GradeDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HelloApplicationTests {

	private FirstService firstService = new FirstServiceImpl();
	@Test
	public void deduplicationName(){
		//given
		String[] nameList = {"Kim","Kim","Choi","Choi","Lee","Cho"};
		//when
		List<String> result = firstService.deduplicationName(Arrays.asList(nameList));

		//then
		//테스트값의 결과를 예측해서 이렇게 적어도 되나?
		assertThat(result.stream().distinct().count()).isEqualTo(4);

	}

	@Test
	public  void okConvertHpTest(){
		//given
		String hpNumber = "010-1234-5678";

		//when
		String result = firstService.convertHp(hpNumber);

		//then
		assertThat(result.contains("-")).isEqualTo(false);
	}

	@Test
	public void lottoGeneratorTest() {
		//given
		int lottoCount = 6;

		//when
		List<Integer> result = firstService.lottoGenerator(lottoCount);

		//then
		System.out.println(result);
		assertThat(result.size()).isEqualTo(6);
	}

	@Test
	public  void calcGradeTest(){
		//given
		List<GradeDto> grades = new ArrayList<>();
		grades.add(GradeDto.builder().subjectName("한국사").score(4.5).build());
		grades.add(GradeDto.builder().subjectName("국어").score(4.5).build());
		grades.add(GradeDto.builder().subjectName("English").score(1).build());
		grades.add(GradeDto.builder().subjectName(" ").score(0).build());
		grades.add(GradeDto.builder().subjectName("Test").score(3).build());

		//when
		double result = firstService.calcGrade(grades);

		//then
		System.out.println(result);
		assertThat(result).isEqualTo(4.5);
	}

}
