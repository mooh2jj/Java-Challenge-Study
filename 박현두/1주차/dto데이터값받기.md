## Spring dto 데이터값 받기

### 소스코드
```java
/* Controller */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public LoginDTO login(@RequestBody LoginDTO loginDTO) {
        return loginDTO;
    }


}

/* DTO */


@Data
@NoArgsConstructor
public class LoginDTO {

    String username;

    String password;
}

```
### 코드 리뷰
* dto로 데이터를 받는 방법은 두가지가 존재한다.
* @RequestBody를 사용하는 방법과 @ModelAttribute를 사용하는 방법이다.
* 생략할 경우, xxx-form-urlencoded로 받는다.

### 결과
