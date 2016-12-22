package com.selise.todoapp.services;

import com.selise.todoapp.dao.TaskDAO;
import com.selise.todoapp.models.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDao;
    
    
    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

    @Override
    public void saveTask(Task task) {
        taskDao.saveTask(task);
    }

    @Override
    public Task findTaskById(int taskId) {
        return taskDao.findTaskById(taskId);
    }

    @Override
    public void updateTaskById(int id, Task task) {
        taskDao.updateTaskById(id, task);
    }

    @Override
    public void deleteTaskById(int taskId) {
        taskDao.deleteTaskById(taskId);
    }

    @Override
    public List<Task> taskExpiresInDays(long timeInMiliSeconds) {
        return taskDao.taskExpiresInDays(timeInMiliSeconds);
    }

    @Override
    public List<Task> taskScheduledForTomorrow() {
        return taskDao.taskScheduledForTomorrow();
    }

    @Override
    public List<Task> searchTAsk(String taskTitle, String expiryDate) {
        return taskDao.searchTAsk(taskTitle, expiryDate);
    }

    
    
}
