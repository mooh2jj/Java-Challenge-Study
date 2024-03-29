# 📢 스터디 규칙
1. 매주 스터디한 내용은 `Readme.MD`에 등록 (by 스터디장)
2. 매주 과제 출제, 스터디원들은 해당주차 과제가 `issues` 탭에 등록되오니 해당 issues란 `comment`로 등록
3. 나머지 1시간에 스터디원들의 발표주제는 `과제한 내용` or `공유하고 싶은 내용`으로 `선택`
4. 발표자는 2명, 스터디날짜 때 `추첨`으로 뽑힘 -> 누가 걸릴지 모르므로 각자 최선을...

<br>

# 📅 스터디 일정

<details>
<summary>1주차(08/20)</summary>
<div markdown="1">

  - 자바 챌린지 스터디를 만든 idea 소개
  - 취지 -> 서로 스터디하면서 시너지를 낼 수 있는 환경설정, 기술 "공유" 세미나

  - POJO -> OOP 형식의 유지보수가능하게 돕는 자바 클래스, 데이터 그릇(Entity, Dto, VO 등)
    으로 활용, 우리 스터디에도 자바 프로그램의 in/out 흐름 파라미터로 사용!

  - Setting 환경: https://github.com/mooh2jj/javaChallenageProg.git
    - SpringBoot REST API로 Dto로 데이터값 POST방식(postman)으로 확인
    - 순수 자바 프로젝트로 진행해도 무관

  - 자바 성적 산출 프로그램 예시
    1) 비즈니스 로직 조건문 if 
    2) 도메인 주도 패턴 - 데이터처리로직 -> 관련 Domain Dto에 메서드로 이동
    3) stream API 로 데이터값 파싱

  - 향후계획: java챌린지스터디 -> Spring(Boot) REST API를 다루는 spring챌린지스터디 계획
  
  - 과제 세팅 소스: https://github.com/mooh2jj/javaChallenageProg.git
</div>
</details>

<br>

<details>
<summary>2주차(08/27)</summary>
<div markdown="2">

  - Builder 패턴
    - 점증적 생성자 패턴 vs 빌더패턴
    - 빌더패턴 이슈 => `NoArgs, AllArgs의 문제` => AllArgsConstructors는 
      생성자로서 인스턴스 맴버변수 순서의 영향을 받아 컴파일 오류가 아닌 런타임 오류가 생겨 치명적인 오류임! 
    - 결국에 NoArsConstrctors, 그리고 Builder가 생성자에 넣는 방식으로 사용
    - 참고) https://velog.io/@mooh2jj/빌더-패턴-왜-쓰는-거야

  - String vs StringBuilder, StringBuffer 
    - 메모리 성능 차이 =>  "+=" vs "append()" 
    - 불변객체 String => Constant pool(상수풀) 메모리에 할당.
      - String 생성방식 ""(리터럴방식) vs new String(); (new 연산자 방식)
    - StringBuffer vs StringBuilder  (멀티스레드 동기화 블록 o, x)

  - String 메서드 
    - equals()	// equals() vs "=="
    - spilt() && join()
    - replaceAll() => `정규표현식` => 활용범위가 넓음. 리눅스에서도 많이 사용
  
  <br>
  
  - 1주차 과제 소스: https://github.com/mooh2jj/javaChallenageProg/commit/a61d43b10d25126afbfcda8d39de17c8a0f4fb79
  - 강의 소스: https://github.com/mooh2jj/javaChallenageProg/commit/b12f5fdaf5000b6692acd5d00374c9fb96312f59
</div>
</details>
  
<br>

<details>
<summary>3주차(09/03)</summary>
<div markdown="3">

  - `Optional`
  : NullPointerException(NPE) 대응 자바 객체  

    1) 생성
    Optional.empty(), of(), ofnullable(), stream()

    2) 접근
    get(), orElse(), orElseGet(), orElseThrow(), ifPresent()


  - `streamAPI` 

    * 함수형 인터페이스 : 인터페이스 하나의 추상메서드 => 람다형식 
      (인자) -> {반환} 
    * 함수형 인터페이스 종류
      - Function : (인자) -> {반환} 
      - Supplyer : () -> {반환}
      - Consumer : (인자) -> { }
      - Predicate : boolean

    * stream의 장점
      for문을 예를 들어, 보기가 좋아  
      메서드 => 뭐하나 선언적 프로그래밍

    * 외부연산 vs 내부연산 : pure하게 관리한다. => "순수함수"

    * lazy 연산 
      : stream => 처음연산 + 중간연산 + 최종연산 
      중간연산의 데이터 호출은 최종연산때까지 반환을 미룬다. 

    * `불변성` 
      : pure function 값의 상태 연산을 하는 도중에는 외부에서 변경을 할 수 없다. => "캡슐화" 와 같은 맥락 

    * stream API 예제
      1) 연산
      2) 내부 데이터 파싱
      3) List<Dto> -> Collect 표현

    * 참고
      - https://velog.io/@mooh2jj/자바-람다Lamda-그리고-함수프로그래밍방식
      - https://velog.io/@mooh2jj/왜-함수형-프로그래밍인가

  -  `StringUtils`
    : StringUtils.hasText(str) => boolean 으로 
    비즈니스 로직에서 가장 많이 받는 데이터 타입인 String의 null 체크에 많이 사용
  
  <br>
  
  - 2주차 과제 소스: https://github.com/mooh2jj/javaChallenageProg/commit/7bdd7217b17b054eb16a889550ea9aec8ec3960f
  - 강의 소스: https://github.com/mooh2jj/javaChallenageProg/commit/a13921b762dcd2a3caf2e8b1d8a420c99483da9e
</div>
</details>

<br>

<details>
<summary>4주차(09/17)</summary>
<div markdown="3">

  - `객체지향 정의`
    : 유지보수, 최대한 다른 뭔가에 영향(side effect)을 최대한 줄이는 방향으로 코딩하는 방식

    1) 절차지향 설계 방식과 비교
    절차지향 : 한 데이터를 가지고 프로시저(함수)가 사용하는 방식, 코드를 짜면 짤수록 한 데이터를 가지고 연관된 프로시저(함수)가 많아진다. => 유지보수가 굉장히 어렵다. 
    
    2) 객체지향과 사실과 오해 - 객체지향을 접근할 때 알아두면 좋은 책
    - 객체는 `책임`에 따른 `역할(추상화)`로 `협력`한다.
    - 참고) https://velog.io/@mooh2jj/book리뷰-객체지향의-사실과-오해


  - `SOLID 원칙` 
    : 객체지향설계를 위한 흐름, 원칙
    
    1) SRP: Client에는 order 행위, Menu에는 choose 행위 등 클래스에 맞는 책임을 할당해준다.
    2) OCP: Chef라는 추상화클래스(인터페이스)를 사용하여 chef를 구현한 클래스가 확장되어도 chef를 사용한 client에게는 변경이 닫혀있다.
    3) LSP: Chef 객체를 생성할 때 chef를 구현한 하위클래스들로 치환해서 생성해도 문제가 없다.
    4) ISP: Chef 인터페이스에는 최소한 메서드만 있다.
    4) DIP: 상위객체인 Client가 Chef라는 추상화클래스(인터페이스)에 의존하여 구현클래스인 하위객체들이 Clinet에 의존하여 의존관계를 역전시킬 수 있다.
    
    * 참고) OrderDish 과제 https://github.com/mooh2jj/orderDish.git

  - `디자인 패턴`
    : SOLID 원칙을 기반으로 객체지향 설계를 위한 공식화된 패턴들
    
    * 종류 : 싱글톤패턴, 팩토리패턴, 전략패턴, 프록시패턴, 빌더패턴, 옵저버패턴, 방문자패턴 등등 
    1) 싱글톤패턴: 하나의 인스턴스를 참조해서 사용하는 패턴, 스프링 빈이 이를 활용한 패턴.
    2) 전략패턴: 하나의 전략을 컨텍스트에 주입하는 패턴, 스프링 DI가 이를 활용한 패턴.
    3) 프록시패턴: 대리자(프록시)를 내새워 호출하는 메서드 기능을 위임하는 패턴, 스프링 AOP가 이를 활용한 패턴.
    
    * 참고) https://velog.io/@mooh2jj/스프링을-위한-디자인패턴-정리
    
  <br>
  
  - 3주차 과제 소스(영권님 과제소스): https://github.com/choiyoungkwon12/javaChallengeStudy/commit/ec9db054587dffd2817ab888890816e528eee22c
</div>
</details>
