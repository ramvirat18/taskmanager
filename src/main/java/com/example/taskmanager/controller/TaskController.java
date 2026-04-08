package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task)
    {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id)
    {
        return taskService.getTaskById(id);
    }

    @PostMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task )
    {
        return taskService.updateTask(id,task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") Long id)
    {
        taskService.deleteTask(id);
        return "Task is deleted Succesfully";
    }






}
