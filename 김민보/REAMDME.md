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

---

###  ✏️ 2주차
- **진행사항**
<br> 1. 함수형 프로그래밍 (Lamda, 함수형 인터페이스, Stream) 정리 &nbsp; 2. 1주차 과제 JPA Entity로 데이터 DB관리 및 반복로직 stream 변환

- **과제**
<br> 1. 1주차 과제 JPA Entity로 데이터 DB관리 및 반복로직 stream 변환 실습 완료하기
<br> 2. 디자인 패턴 정리  -> https://velog.io/@minbo2002/spring-design-pattern
<br> 3. Reflection, Proxy 정리 -> https://velog.io/@minbo2002/Reflection-Proxy
<br> 4. 예외처리 Exception(Checked Exception, Unchecked Exception) 정리 -> https://velog.io/@minbo2002/CheckedException-UncheckedException

---

###  ✏️ 3주차
- **진행사항**
<br> 1. 미션발표 및 코드리뷰
<br> 2. OOP -> SOLID원칙 -> 디자인패턴(스프링에서 쓰이는 디자인패턴 위주 설명)
<br> 3. SOLID 원칙에 기반한 프로그램 리팩토링

- **과제**
<br> 1. 노션에 정리된 키워드 블로그 정리 -> SOLID 원칙(https://velog.io/@minbo2002/SOLID-5principles)
<br> 2. SOLID 원칙에 기반한 프로그램 리팩토링 완료하기
```java
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        client.order("파스타");
    }
}

// 스프링에서 @Configuration 기능
class CreateConfig {

    public List<MenuItem> items() {

        return List.of(
                new MenuItem("갈비찜", "한식", "젓가락"),
                new MenuItem("파스타", "양식", "포크"),
                new MenuItem("마파두부", "중식", "숟가락")
        );

        /*
        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem("갈비찜", "한식", "젓가락"));
        items.add(new MenuItem("파스타", "양식", "포크"));
        items.add(new MenuItem("마파두부", "중식", "숟가락"));

        return items;
        */
    }

    public Chef chef(MenuItem menuItem) {

        Map<String, Chef> chefMap = Map.of(
            "한식", new KoreanChef(),
            "양식", new WesternChef(),
            "중식", new ChineseChef()
        );

        if (chefMap.containsKey(menuItem.getType())) {
            return chefMap.get(menuItem.getType());
        } else {
            throw new IllegalStateException("해당 요리는 주문 할 수 없습니다.");
        }
        /*
        if (menuItem.getType().equals("한식")) {
            return new KoreanChef();
        } else if (menuItem.getType().equals("양식")) {
            return new WesternChef();
        } else if (menuItem.getType().equals("중식")) {
            return new ChineseChef();
        } else {
            throw new IllegalStateException("해당 요리는 주문 할 수 없습니다.");
        }
        */
    }
}

class Client {

    CreateConfig createConfig = new CreateConfig();
    Menu menu = new Menu(createConfig.items());

    public void order(String menuName) {

        System.out.println("고객은 " + menuName + "을 주문하였습니다.");
        MenuItem menuItem = menu.choose(menuName);

        Chef chef = createConfig.chef(menuItem);
        System.out.println(chef + "는 " + menuItem.getName() + " 주문을 받았습니다.");

        Dish dish = (Dish) chef.makeDish(menuItem);
        System.out.println(chef + "는 " + dish.getName() + "을 만들었습니다.");

        System.out.println("고객은 주문한 " + menuName + "을 받았으며, " + dish.getHowTo() + "을 사용하였습니다.");

    }
}

class Menu {

    private List<MenuItem> items;

    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public MenuItem choose(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("해당 주문의 요리는 없습니다."));
    }

    /*
    public MenuItem choose(String name) {

        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalStateException("해당주문의 요리는 없습니다.");
    }
    */
}

class MenuItem {

    private String name;
    private String type;
    private String howTo;

    public MenuItem(String name, String type, String howTo) {
        this.name = name;
        this.type = type;
        this.howTo = howTo;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getHowTo() {
        return howTo;
    }

}

class Dish {

    private String name;
    private String type;
    private String howTo;


    public Dish(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.type = menuItem.getType();
        this.howTo = menuItem.getHowTo();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getHowTo() {
        return howTo;
    }
}


interface Chef {
    Dish makeDish(MenuItem menuItem);

}

class KoreanChef implements Chef {
    @Override
    public Dish makeDish(MenuItem menuItem) {
        return new Dish(menuItem);
    }

    @Override
    public String toString() {
        return "한식요리사";
    }
}

class WesternChef implements Chef {
    @Override
    public Dish makeDish(MenuItem menuItem) {
        return new Dish(menuItem);
    }

    @Override
    public String toString() {
        return "양식요리사";
    }
}

class ChineseChef implements Chef {
    @Override
    public Dish makeDish(MenuItem menuItem) {
        return new Dish(menuItem);
    }

    @Override
    public String toString() {
        return "중국요리사";
    }
}
```