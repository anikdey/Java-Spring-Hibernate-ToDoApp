package com.selise.todoapp.dao;

import com.selise.todoapp.models.Task;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Task task;

    @Override
    public List<Task> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Task.class).addOrder(Order.asc("taskDate")).list();
    }

    @Override
    public void saveTask(Task task) {
        sessionFactory.getCurrentSession().persist(task);
    }

    @Override
    public Task findTaskById(int taskId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("id", taskId));
        task = (Task) criteria.uniqueResult();
        return task;
    }

    @Override
    public void updateTaskById(int id, Task task) {
        Query query = sessionFactory.getCurrentSession().createQuery("update " + Task.class.getSimpleName()
                + " set taskTitle = :taskTitle, "
                + "taskDescription = :taskDescription, "
                + "taskDate = :taskDate "
                + " where id = :id");
        query.setParameter("taskTitle", task.getTaskTitle());
        query.setParameter("taskDescription", task.getTaskDescription());
        query.setParameter("taskDate", task.getTaskDate());
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteTaskById(int taskId) {
        task = (Task) sessionFactory.getCurrentSession().get(Task.class, taskId);
        if (task != null) {
            sessionFactory.getCurrentSession().delete(task);
        }
    }

    @Override
    public List<Task> taskExpiresInDays(long timeInMiliSeconds) {
        Calendar calendar = Calendar.getInstance();
        long upcomingTimeInMiliSeconds = timeInMiliSeconds + calendar.getTimeInMillis();
        Date todaysDate = new Date(calendar.getTimeInMillis());
        Date futureDate = new Date(upcomingTimeInMiliSeconds);

        List<Task> tasks = sessionFactory.getCurrentSession()
                .createQuery("FROM " + Task.class.getSimpleName() + " AS task WHERE task.taskDate BETWEEN :todaysDate AND :futureDate ")
                .setParameter("todaysDate", todaysDate)
                .setParameter("futureDate", futureDate)
                .list();

        Collections.sort(tasks, new Comparator<Task>() {
            public int compare(Task taskOne, Task taskTwo) {
                return taskOne.getTaskDate().compareTo(taskTwo.getTaskDate());
            }
        });

        return tasks;
    }

    @Override
    public List<Task> taskScheduledForTomorrow() {
        Calendar calendar = Calendar.getInstance();
        long upcomingTimeInMiliSeconds = 86400000 + calendar.getTimeInMillis();
        Date futureDate = new Date(upcomingTimeInMiliSeconds);

        return sessionFactory.getCurrentSession()
                .createCriteria(Task.class)
                .add(Restrictions.eq("taskDate", futureDate))
                .addOrder(Order.asc("taskDate")).list();
    }

    @Override
    public List<Task> searchTAsk(String taskTitle, String expiryDate) {

        Calendar calendar = Calendar.getInstance();
        List<Task> tasks = null;
        if (expiryDate.equals("")) {

            Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
            criteria.add(Restrictions.ilike("taskTitle", taskTitle, MatchMode.ANYWHERE));
            tasks = criteria.addOrder(Order.asc("taskDate")).list();

        } else if (!expiryDate.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date parsed;
            try {
                parsed = format.parse(expiryDate);
                Date todaysDate = new Date(calendar.getTimeInMillis());
                Date futureDate = new Date(parsed.getTime());

                System.out.println("Future Date " + futureDate);
                System.out.println("Todays  Date " + todaysDate);

                tasks = sessionFactory.getCurrentSession()
                        .createQuery("FROM " + Task.class.getSimpleName() + " AS task WHERE task.taskTitle like :taskTitle AND task.taskDate BETWEEN :todaysDate AND :futureDate ")
                        .setParameter("taskTitle", "%" + taskTitle + "%")
                        .setParameter("todaysDate", todaysDate)
                        .setParameter("futureDate", futureDate)
                        .list();

                Collections.sort(tasks, new Comparator<Task>() {
                    public int compare(Task taskOne, Task taskTwo) {
                        return taskOne.getTaskDate().compareTo(taskTwo.getTaskDate());
                    }
                });
            } catch (ParseException ex) {

            }

        }

        return tasks;
    }

}
