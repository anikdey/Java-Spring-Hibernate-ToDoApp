
package com.selise.todoapp.dao;

import com.selise.todoapp.models.Task;
import java.util.List;

public interface TaskDAO {

    List<Task> findAll();
    
    List<Task> taskExpiresInDays(long timeInMiliSeconds);
    
    List<Task> taskScheduledForTomorrow();
    
    List<Task> searchTAsk(String taskTitle, String expiryDate);

    void saveTask(Task task);

    Task findTaskById(int taskId);

    void updateTaskById(int id, Task task);

    void deleteTaskById(int taskId);
}
