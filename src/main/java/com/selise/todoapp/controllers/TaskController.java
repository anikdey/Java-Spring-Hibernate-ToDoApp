package com.selise.todoapp.controllers;

import com.selise.todoapp.models.Task;
import com.selise.todoapp.services.TaskService;
import com.selise.todoapp.validators.TaskValidator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/admin/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskValidator taskValidator;

    private Task task;

    @InitBinder
    public void bindDate(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "taskDate", new CustomDateEditor(format, true));
    }

    @RequestMapping(value = "/task-list", method = RequestMethod.GET)
    public String taskList(Model model) {

        model.addAttribute("tasksScheduledForToday", taskService.taskExpiresInDays(0));
        model.addAttribute("tasksScheduledForTomorrow", taskService.taskScheduledForTomorrow());
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("title", "Task List");
        return "task/index";
    }

    @RequestMapping(value = "/expires-in-seven-days", method = RequestMethod.GET)
    public String taskExpiresInTwoDays(Model model) {
        model.addAttribute("tasks", taskService.taskExpiresInDays(86400000 * 7));
        model.addAttribute("title", "Task List");
        return "task/taskExpiresInDays";
    }

    @RequestMapping(value = "/expires-in-fifteen-days", method = RequestMethod.GET)
    public String taskExpiresInFiveDays(Model model) {
        model.addAttribute("tasks", taskService.taskExpiresInDays(86400000 * 15));
        model.addAttribute("title", "Task List");
        return "task/taskExpiresInDays";
    }

    @RequestMapping(value = "/search-task", method = RequestMethod.GET)
    public String searchTask(Model model) {
        model.addAttribute("title", "Search Task");
        model.addAttribute(new Task());
        return "task/search";
    }

    @RequestMapping(value = "/search-task", method = RequestMethod.POST)
    public String porcessSearch(Model model, RedirectAttributes redirectAttributes,@RequestParam Map<String, String> taskSearch) {
        
        String taskTitle = taskSearch.get("taskTitle");
        String expiryDate = taskSearch.get("expiryDate");
        model.addAttribute("tasks", taskService.searchTAsk(taskTitle, expiryDate));
        model.addAttribute("taskTitle", taskTitle);
        model.addAttribute("expiryDate", expiryDate);
        model.addAttribute("title", "Search Result");
        return "task/searchResult";
    }
    
    
    @RequestMapping(value = "/add-new-task", method = RequestMethod.GET)
    public String addTask(Model model) {
        model.addAttribute("title", "Task New Task");
        model.addAttribute(new Task());
        return "task/create";
    }

    @RequestMapping(value = "/add-new-task", method = RequestMethod.POST)
    public String saveTask(Model model, @Valid Task task, BindingResult result, RedirectAttributes redirectAttributes) {
        taskValidator.validate(task, result);
        //taskValidator.validateDate(task.getTaskDate(), result);
        if (result.hasErrors()) {
            model.addAttribute("title", "Task New Task");
            return "task/create";
        }
        taskService.saveTask(task);
        redirectAttributes.addFlashAttribute("message", "Task was successfully saved.");
        return "redirect:/admin/task/task-list";
    }

    @RequestMapping(value = "/show-task/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable("id") int id) {
        task = taskService.findTaskById(id);
        model.addAttribute("title", "Task - " + task.getTaskTitle());
        model.addAttribute("task", task);
        return "task/show";
    }

    @RequestMapping(value = "/edit-task/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id) {
        task = taskService.findTaskById(id);
        model.addAttribute("title", "Edit Task - " + task.getTaskTitle());
        model.addAttribute("task", task);
        return "task/edit";
    }

    @RequestMapping(value = "/edit-task/{id}", method = RequestMethod.POST)
    public String edit(Model model, @PathVariable("id") int id, @Valid Task task, BindingResult result, RedirectAttributes redirectAttributes) {
        taskValidator.validate(task, result);
        if (result.hasErrors()) {
            model.addAttribute("title", "Edit Task");
            return "task/edit";
        }
        taskService.updateTaskById(id, task);
        redirectAttributes.addFlashAttribute("message", "Task was successfully updated.");
        return "redirect:/admin/task/task-list";
    }

    @RequestMapping(value = "/delete-task/{id}", method = RequestMethod.GET)
    public String deleteCountryById(Model model, @PathVariable("id") int id,
            RedirectAttributes redirectAttributes) {
        taskService.deleteTaskById(id);
        redirectAttributes.addFlashAttribute("message", "Task was successfully deleted.");
        return "redirect:/admin/task/task-list";
    }
}
