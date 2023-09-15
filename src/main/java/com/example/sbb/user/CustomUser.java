package com.example.sbb.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
public class CustomUser extends User {
    private SiteUser siteUser = new SiteUser();
    // 일반 이메일 계정으로 가입한 유저의 정보를 표시할 때 연결해주는 곳
    private final Long id;
    private final String userName;
    private final String nickName;
    private final String firstname;
    private final String lastname;
    private final String phone;
    private final String email;
    private final LocalDateTime createDate;
    private final String imgFilePath;
    private final Boolean gender;
    private final LocalDate birthDate;


    public CustomUser(SiteUser siteUser, Collection<? extends GrantedAuthority> authorities) {
        super(siteUser.getUsername(),
                siteUser.getPassword(),
                authorities);
        this.id = siteUser.getId();
        this.userName = siteUser.getUsername();
        this.nickName = siteUser.getNickName();
        this.firstname = siteUser.getFirstName();
        this.lastname = siteUser.getLastName();
        this.phone = siteUser.getPhone();
        this.email = siteUser.getEmail();
        this.birthDate = siteUser.getBirthDate();
        this.imgFilePath = siteUser.getImgFilePath();
        this.gender = siteUser.getGender();
        this.createDate = siteUser.getCreateDate();
    }
}
