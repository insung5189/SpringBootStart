package com.example.sbb.admin;

import com.example.sbb.user.SiteUser;
import com.example.sbb.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final AdminService adminService;

    @GetMapping
    public String adminPage(Model model) {
        // 관리자 페이지에 표시할 사용자 목록을 가져온다 (이 데이터는 서비스 계층에서 가져올 것)
        List<SiteUser> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "admin";
    }

    @PostMapping("/update-role")
    public String updateRole(@RequestParam("userId") Long userId, @RequestParam("newRole") String newRole, RedirectAttributes redirectAttributes) {
        adminService.updateUserRole(userId, newRole);
        redirectAttributes.addFlashAttribute("message", "사용자 권한이 업데이트되었습니다.");
        return "redirect:/admin";
    }
}
