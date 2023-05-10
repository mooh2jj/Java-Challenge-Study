# 자바 챌린지 스터디

###  ✏️ 1주차
- **진행사항**
<br> 1. 자기소개 &nbsp; 2. 스터디 취지, 방향, 구성 방식 이해

- **과제**
<br> 1. 사용툴 설치 및 이해 (IntelliJ, MySQL8.0, DB접속툴 HeidiSQL, POSTMAN, git/github)
<br> 2. Spring Boot REST API로 POST방식의 DTO 데이터값 POSTMAN으로 확인하기 
<br> 3. 로또 생성기 구현 (로또 번호 갯수 input -> 랜덤 로또 번호 6자리를 생성하는 프로그램 구현)
```java
@Data
@NoArgsConstructor
public class LottoRequestDto {

    private int num;

    @Builder
    public LottoRequestDto(int num) {
        this.num = num;
    }
}

@RestController
@Slf4j
public class TestController {

    // 로또 생성기
    @PostMapping("/test4")
    public List<Integer> test4(@RequestBody LottoRequestDto request) {

        int numberCount = request.getNum();
        log.info("numberCount : {}", numberCount);

        Random random = new Random();
        List<Integer> lottoNumber = new ArrayList<>();
        log.info("lottoNumber : {}", lottoNumber);

        while (lottoNumber.size() < numberCount) {
            int randomNumber = random.nextInt(45) + 1;
            log.info("randomNumber : {}", randomNumber     );

            if(!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber);
            }
        }

        return lottoNumber;
    }
}

```
<br> 4. 자바성적산출 프로그램 구현 (정규표현식을 사용하여 과목이름이 한글인 경우 count하고 평균을 산출하는 프로그램 구현)
```java
@Data
@NoArgsConstructor
public class SubjectRequestDto {

    private String title;
    private int score;

    @Builder
    public SubjectRequestDto(String title, int score) {
        this.title = title;
        this.score = score;
    }
}

@Data
@NoArgsConstructor
public class SubjectResponseDto {

    private int count;
    private int total;
    private double average;

    @Builder
    public SubjectResponseDto(int count, int total, double average) {
        this.count = count;
        this.total = total;
        this.average = average;
    }
}

@RestController
@Slf4j
public class TestController {

    @PostMapping("/test5")
    public SubjectResponseDto test5(@RequestBody List<SubjectRequestDto> subjects) {

        int total = 0;
        int count = 0;

        for(SubjectRequestDto subject : subjects) {
            if(isKorSubjectName(subject.getTitle())) {
                log.info("subject.getTitle() : {}", subject.getTitle());
                total += subject.getScore();
                count++;
            }
        }

        double average = (count > 0) ? total/count : 0;

        return SubjectResponseDto.builder()
                .count(count)
                .total(total)
                .average(average)
                .build();
    }

    // 과목 한글확인
    private boolean isKorSubjectName(String str) {
        return Pattern.compile("^[ㄱ-ㅎ가-힣]*$").matcher(str).matches();

    }
}

```