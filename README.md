# 📢 스터디 규칙
1. 매주 스터디는 2시간을 기본으로 한다. 스터디원 N명이 발표 진행 1시간, 스터디장 기술소개시간 1시간을 한다, 스터디원 발표 내용은 이 [java-challenge-study](https://github.com/mooh2jj/Java-Challenge-Study)를 `fork`한 후 본인 Repository에서 각 `본인이름의 디렉토리`에 `PR(Pull Request)`하여 정리해주면 된다.
  * fork&PR 영상 참고 -> https://www.youtube.com/watch?v=yr6IzOGoMsQ

2. 발표시 CodeReview인 점을 감안하여 `Code 내용을 중심으로 발표`를 권장한다. (자유발표도 가능, 발표는 하고싶은 분을 1순위, 없다면 당일날 랜덤으로 정해집니다)
3. 나머지 스터디원들도 매주 해당 내용 숙지를 위해 스터디한 내용 학습, 학습한 내용을 `해당 본인이름의 디렉토리`에 `PR`하여 정리한다. 
4. 보증금은 `4만원이며 1번 불참시 이유불문하고 1만원 차감`, 스터디룸비용을 제하고 계속 합류한 분들에게만 지급된다.

<br>

# 📅 스터디 일정

<details>
<summary>OT(2023/01/28)</summary>
<div markdown="1">

  * 자기소개 시간
  * 스터디 취지, 방향, 구성 방식 설명
  * 과제
  ```
  1) 사용 툴 설치및 이해하기 
   * IntelliJ(얼티메이트 버전 추천-플러그인 사용 가능)
   * MySQL, DB 접속 HediSQL or Dbeaver
   * e2e 테스트용 postman
   * git/github
 
  2) 해당 레포지토리 fork & PR 해보기
 
  3) Setting 환경 -> REST API springBoot 
    * SpringBoot REST API로 Dto로 데이터값 POST방식(postman)으로 확인
  
  4) 로또 생성기 구현
    * 로또 번호 갯수 input -> 랜덤 로또 번호 6자리 생성 output 프로그램 구현

  챌린지) 자바 성적 산출 프로그램 구현
    * 과목이름이 한글인 경우에 count, 평균을 산출해주세요. (정규표현식을 사용해주세요)
  ```
 * 환경셋팅 - [https://www.notion.so/bb4d80cb1a094696b8ff27f4cd52bb00](https://www.notion.so/bb4d80cb1a094696b8ff27f4cd52bb00)
</div>
</details>

<details>
<summary>1week(2023/02/04)</summary>
<div markdown="1">

  * POJO -> OOP 형식의 유지보수가능하게 돕는 자바 클래스 
    * 데이터 그릇(Entity, Dto, VO 등)으로 활용
    * SpirngBoot의 in/output 흐름 어노테이션 파라미터로 활용
    
  * REST API로 Dto 필드 데이터값 POST방식(postman)으로 output 확인
    * 순수 자바 프로젝트로 진행해도 무관
    * ex) 자바 성적 산출 프로그램

  * 비즈니스 로직 조건문 if, 반복문 for, while
    * 도메인 주도 패턴 - 데이터처리로직 -> 관련 Domain Dto에 메서드로 이동
    * Stream API로 데이터값 파싱
    * ex) lottoGenerate 랜덤번호 산출
 
 * 과제 - https://github.com/mooh2jj/Java-Challenge-Study/issues/2
 
 * 정리 - https://www.notion.so/1week-f6fec789ea48479d976f4a37ae57cd56
</div>
</details>

<br>


