package com.selise.todoapp.validators;

import com.selise.todoapp.models.Task;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TaskValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskTitle", "NotEmpty.taskTitle");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskDate", "NotEmpty.taskDate");
    }

    public void validateDate(Date date, Errors errors) {
     

    }

}
