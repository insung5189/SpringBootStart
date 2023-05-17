package com.example.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 25) // username 길이가 3-25 사이여야 한다는 검증
    @NotEmpty(message = "사용자ID는 필수항목입니다.") // username 은 필수항목
    private String username;

    @NotEmpty(message = "비밀번호는 필수항목입니다.") // password1 은 필수항목
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.") // password2 은 필수항목
    private String password2;

    @NotEmpty(message = "이메일은 필수항목입니다.") // email 은 필수항목
    @Email // email 속성에는 @Email 애너테이션이 적용됨. @Email은 해당 속성의 값이 이메일형식과 일치하는지를 검증
    private String email;
}