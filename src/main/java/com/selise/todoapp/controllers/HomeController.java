package com.selise.todoapp.controllers;

import com.selise.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class HomeController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("title", "ToDoApp : Dashboard");
        model.addAttribute("tasksScheduledForToday", taskService.taskExpiresInDays(0));
        return "home/index";
    }
}
