package com.example.sbb.user;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk
    private Long id;

    @Column(unique = true)
    private String username; // 유저아이디

    private String password;

    @Column(unique = true)
    private String email;

    @Column(name = "role", columnDefinition = "ENUM('ADMIN','AUTHOR','MEMBER','SUPERADMIN','USER')")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime createDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;
}