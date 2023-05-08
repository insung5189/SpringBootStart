package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러 어노테이션 선언
public class MainController2 { // 복습용
    @RequestMapping("/sbb") // 이런 형태로 주소값을 받으면 아래 메서드대로 처리할거야 라는 뜻
    @ResponseBody // 응답할 수 있는 수단 (return 값을 통해서 보냄)
    public String index() {
        System.out.println("출력"); // 내 서버 콘솔에만 뜬것임.
        return "출력"; // ResponseBody 를 통해 응답이 되어서 페이지 상 body 로 출력된 것.
    }

    @RequestMapping("/plus1") // 브라우저(클라이언트)에서 요청될 때 주소표시줄에 /plis1 ? a=? & b=? 하는 형태로 매개변수의 값을 주어야 함.
    @ResponseBody
    public int showPlus1(int a, int b) { // 매개변수로 a와 b를 받도록 변수를 설치해줌.
        return a + b;
    }

    @RequestMapping("/time1")
    @ResponseBody
    public int showTime1(int a, int b) {
        return a * b;
    }

    @RequestMapping("/minus1")
    @ResponseBody
    public int showMinus1(int a, int b) {
        return a - b;
    }

    @RequestMapping("/divin1")
    @ResponseBody
    public int showDivin(int a, int b) {
        return a / b;
    }

    @RequestMapping("/modulus")
    @ResponseBody
    public int showModulus(int a, int b) {
        return a % b;
    }

    int a = 0;

    @RequestMapping("/incre")
    @ResponseBody
    public int showIncre() {
        return a++;
    }

    @RequestMapping("/food/{name}")
    @ResponseBody
    public String food(@PathVariable String name) {
        return switch (name) {
            case "떡볶이" -> "매운거";
            case "짜장면" -> "안매운거";
            case "제육볶음" -> "밥";
            case "서브웨이" -> "빵";
            default -> "제대로 입력하세요";
        };

    }
    @RequestMapping("/name")
    @ResponseBody
    public String name () { // 이름 나타내기
        return "제 이름은 황인성입니다.";
    }

    @RequestMapping("/age")
    @ResponseBody
    public String age () { // 나이 나타내기
        return "제 나이는 31살 입니다.";
    }

    @ResponseBody
    @RequestMapping("/height")
    public String height () { // 키 나타내기
        return "제 키는 191 입니다.";
    }
    @ResponseBody
    @RequestMapping("/plus")
    public int showPlus ( int a, int b){ // 매개변수를 활용한 플러스 메서드
        return a + b;
    }
    @ResponseBody
    @RequestMapping("/minus")
    public int showMinus ( int a, int b){ // 매개변수를 활용한 마이너스 메서드
        return a - b;
    }
    int e = 0; // int a를 증가하는 메서드 바깥에서 초기화.
    @ResponseBody
    @RequestMapping("/increase")
    public int showIncrease () {
        return e++; // 페이지를 조회할 때마다 a값이 증가하게 됨.
    }
    @ResponseBody
    @RequestMapping("/MBTI/{name}")
    public String showMBTI (@PathVariable String name)
    { // @PathVariable : 경로 변수 => 여기선 /MBTI/{name}에서 name이 매개변수 name으로 들어옴.
        return switch (name) { // switch expression
            case "홍길동" -> "INFP";
            case "홍길순", "임꺽정" -> "ENFP"; // 중복된 케이스 한번에 처리.
            case "반장", "선생님" -> {
                char e = 'E';
                char s = 'S';
                char t = 'T';
                char j = 'J';
                yield "" + e + s + t + j;
            }
            case "인프제" -> { // 중괄호를 통해서 수식도 넣을 수 있다.
                char j = 'J';
                yield "INF" + j; // 수식안에서 return 할땐 yield 를 사용함.
            }
            default -> "모름"; // 아무런 케이스에도 해당하지 않는 default 값일때
        };
    }
}