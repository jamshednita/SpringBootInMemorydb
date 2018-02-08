package com.test.dao;

import java.util.List;

import com.test.model.Task;

public interface TaskDao {
    void create(Task task);

    void update(Task task);

    Task getTaskById(long id);
    
    List<Task> getAllTasks();

    void delete(long id);
}
