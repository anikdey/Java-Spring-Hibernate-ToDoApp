package com.selise.todoapp.controllers;

import com.selise.todoapp.models.Role;
import com.selise.todoapp.models.User;
import com.selise.todoapp.services.RoleService;
import com.selise.todoapp.services.UserService;
import com.selise.todoapp.validators.UserFormValidator;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

    @Autowired
    private UserFormValidator userFormValidator;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new User());
        //model.addAttribute("roles", roleService.findAll());
        model.addAttribute("title", "Registration");
        return "login/register";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String processUserRegistration(Model model, @Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleService.findRoleById(1));
        user.setAuthorities(roles);
        userFormValidator.validate(user, result);
        userFormValidator.passwordValidator(user, result);
        userFormValidator.isUniqueEmail(user.getEmail(), result);
        userFormValidator.isUniqueUsername(user.getUsername(), result);
        if (result.hasErrors()) {
            model.addAttribute("title", "Registration");
            return "login/register";
        }

        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Successfully Registered");
        return "redirect:/";

    }

}
