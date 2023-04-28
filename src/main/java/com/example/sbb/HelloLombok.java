package com.example.sbb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter // 롬복의 내장기능인 Getter(getter를 자동으로 만들어준다)
@Setter // 롬복의 내장기능인 Setter(setter를 자동으로 만들어준다)
public class HelloLombok {
    private String Hello; // 롬복에 의해서 호출당한 String Hello
    private int lombok; // 롬복에 의해서 호출당한 int lombok
    public static void main(String[] args) {
        HelloLombok hellolombok = new HelloLombok();
        hellolombok.setHello("헬로");
        hellolombok.setLombok(50);

        System.out.println(hellolombok.getHello()); // 롬복처리한 변수를 getter로 호출
        System.out.println(hellolombok.getLombok()); // 롬복처리한 변수를 getter로 호출

    }

}
