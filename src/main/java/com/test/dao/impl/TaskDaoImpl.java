package com.test.dao.impl;

import java.util.List;

import com.test.dao.TaskDao;
import com.test.model.Task;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TaskDaoImpl implements TaskDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Task task) {
        //entityManager.persist(apiRequest);
    	entityManager.persist(task);
    }

    @Override
    public void update(Task task) {
        entityManager.merge(task);
    }

    @Override
    public Task getTaskById(long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void delete(long id) {
        Task task = getTaskById(id);
        if (task != null) {
            entityManager.remove(task);
        }
    }

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT t FROM Task t").getResultList();
	}

}
