package com.selise.todoapp.controllers;

import com.selise.todoapp.models.Role;
import com.selise.todoapp.models.User;
import com.selise.todoapp.services.RoleService;
import com.selise.todoapp.services.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("title", "ToDoApp: Login");
        return "login/index";
    }

    //@PostConstruct
    public void dumpDummyData() {
        roleService.dumpDummyRole();
        Role role = roleService.findRoleById(1);
        List<Role> authorities = new ArrayList<Role>();
        authorities.add(role);
        User user = new User();
        user.setFirstName("Anik");
        user.setEmail("info.anikdey003@gmail.com");
        user.setUsername("anikdey");
        user.setPassword("anikdey");
        user.setAuthorities(authorities);
        userService.saveUser(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication,
            RedirectAttributes redirectAttributes) {
        boolean invalidateHttpSession = true;
        SecurityContextHolder.clearContext();
        if (invalidateHttpSession) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }
        redirectAttributes.addFlashAttribute("message", "You are successfully logged out.");
        return "redirect:/";
    }
}
