
package com.selise.todoapp.validators;

import com.selise.todoapp.models.User;
import com.selise.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.user.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.user.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.user.username");

        if (user.getPassword().trim().length() < 3 || user.getPassword().trim().length() > 10) {
            errors.rejectValue("password", "user.password");
        }

    }

    public void passwordValidator(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.user.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.user.confirmPassword");
        User user = (User) target;
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("password", "user.passwordMissMatch");
        }
    }

    public boolean isUniqueEmail(String email, Errors errors) {
        if (!userService.isUniqueEmail(email)) {
            errors.rejectValue("email", "user.emailAlreadyTaken");
            return false;
        }
        return true;
    }

    public boolean isUniqueUsername(String username, Errors errors) {
        if (!userService.isUniqueUsername(username)) {
            errors.rejectValue("username", "user.userNameNotAvailable");
            return false;
        }
        return true;
    }
}
