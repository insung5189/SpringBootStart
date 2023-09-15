package com.example.sbb.user;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk
    private Long id;

    @Column(unique = true)
    private String username; // 유저아이디

    @Column(name = "password")
    private String password;

    @Column(unique = false)
    private String email;

    @Column(name = "role", columnDefinition = "ENUM('ADMIN','AUTHOR','MEMBER','SUPERADMIN','USER')")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime createDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @LastModifiedDate
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @Column(name = "nick_name")
    private String nickName; // 사용자 닉네임

    @Column(name = "first_name")
    private String firstName; // 사용자 본명 중 이름

    @Column(name = "last_name")
    private String lastName; // 사용자 본명 중 성

    @Column(name = "phone")
    private String phone; // 사용자 연락처

    @Column(name = "birth_date")
    private LocalDate birthDate; // 사용자 생년월일

    @Column(name = "img_file_path")
    private String imgFilePath; // 사용자 프로필 이미지 파일 경로

    @Column(name = "img_file_name")
    private String imgFileName; // 사용자 프로필 이미지 파일 이름

    @Column(name = "gender")
    private Boolean gender; // 사용자 성별 (true : 남자 / false : 여자)

    // 소셜로그인 기능을 위한 프로바이더와 프로바이더_id 칼럼 추가
    @Column(name = "provider")
    private String provider;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "is_active")
    private boolean isActive = true; // soft Delete를 처리하기 위한 칼럼. (회원 활성 여부)

    public void deactivate() {
        this.isActive = false;
    }

}