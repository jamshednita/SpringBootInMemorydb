package com.test.service.impl;

import java.util.List;

import com.test.dao.TaskDao;
import com.test.service.TaskService;
import com.test.model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao apiRequestDao;

    @Override
    public void create(Task task) {
        apiRequestDao.create(task);
    }

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		apiRequestDao.update(task);
		
	}

	@Override
	public Task getTaskById(long id) {
		// TODO Auto-generated method stub
		return apiRequestDao.getTaskById(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		apiRequestDao.delete(id);
		
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return apiRequestDao.getAllTasks();
	}
}
