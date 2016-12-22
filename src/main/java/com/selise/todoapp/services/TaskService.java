/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selise.todoapp.services;

import com.selise.todoapp.models.Task;
import java.util.List;

public interface TaskService {

    List<Task> findAll();

    List<Task> taskExpiresInDays(long timeInMiliSeconds);
    
    List<Task> taskScheduledForTomorrow();
    
    List<Task> searchTAsk(String taskTitle, String expiryDate);

    void saveTask(Task task);

    Task findTaskById(int taskId);

    void updateTaskById(int id, Task task);

    void deleteTaskById(int taskId);

}
