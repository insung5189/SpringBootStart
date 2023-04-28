package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello () {
        return "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ";
    }
    /*
    public void hello2 () {
        HelloLombok hellolombok = new HelloLombok();
        hellolombok.setHello("헬로");
        hellolombok.setLombok(50);

        System.out.println(hellolombok.getHello()); // 롬복처리한 변수를 getter로 호출
        System.out.println(hellolombok.getLombok()); // 롬복처리한 변수를 getter로 호출
    }

     */

}