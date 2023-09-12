package com.example.sbb.admin;

import com.example.sbb.user.SiteUser;
import com.example.sbb.user.UserRepository;
import com.example.sbb.user.UserRole;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public List<SiteUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserRole(Long userId, String newRole) {
        SiteUser siteUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));

        siteUser.setRole(UserRole.valueOf(newRole));
        userRepository.save(siteUser);
    }
}