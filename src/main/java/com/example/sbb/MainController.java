package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MainController {
//    @ResponseBody
    @GetMapping("/sbb") // 클라이언트가 뭘 달라는 요청
    @ResponseBody
    public String index () {
        return "안녕하세요 SBB에 오신것을 환영합니다";
    }
}