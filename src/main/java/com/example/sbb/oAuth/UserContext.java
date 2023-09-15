package com.example.sbb.oAuth;

import com.example.sbb.user.SiteUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserContext extends User implements OAuth2User {
    // 소셜계정으로 가입한 유저의 정보를 표시할 때 연결해주는 곳
    private final Long id;
    private final String username;
    private final String nickname;
    private final String firstname;
    private final String lastname;
    private final String phone;
    private final String email;
    private final LocalDateTime createDate;
    private final String imgFilePath;
    private final Boolean gender;
    private final LocalDate birthDate;
    private Map<String, Object> attributes;
    private String userNameAttributeName;


    public UserContext(SiteUser siteUser, List<GrantedAuthority> authorities) {
        super(siteUser.getUsername(), siteUser.getPassword(), authorities);
        this.id = siteUser.getId();
        this.username = siteUser.getUsername();
        this.nickname = siteUser.getNickName();
        this.firstname = siteUser.getFirstName();
        this.lastname = siteUser.getLastName();
        this.phone = siteUser.getPhone();
        this.email = siteUser.getEmail();
        this.birthDate = siteUser.getBirthDate();
        this.imgFilePath = siteUser.getImgFilePath();
        this.gender = siteUser.getGender();
        this.createDate = siteUser.getCreateDate();
    }

    public UserContext(SiteUser siteUser, List<GrantedAuthority> authorities, Map<String, Object> attributes, String userNameAttributeName) {
        this(siteUser, authorities);
        this.attributes = attributes;
        this.userNameAttributeName = userNameAttributeName;
    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return super.getAuthorities().stream().collect(Collectors.toSet());
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public String getName() {
        return this.getAttribute(this.userNameAttributeName).toString();
    }
}