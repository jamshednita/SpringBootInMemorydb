package com.test;

import com.test.model.Task;
import com.test.service.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@EnableAutoConfiguration
public class TaskController {

    @Autowired
    private TaskService apiRequestService;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @RequestMapping("/home")
    public String home() {
     return "index";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createTask(@RequestBody Task task) {
        //if (personService.isValid(person)) {
    	apiRequestService.create(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
        //}
        //return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity updateTask(@RequestBody Task task) {
    	apiRequestService.update(task);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task taskById(@PathVariable Integer id) {
        return apiRequestService.getTaskById(id);
    }
    
    @RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> allTasks() {
        return apiRequestService.getAllTasks();
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable Integer id) {
        apiRequestService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
