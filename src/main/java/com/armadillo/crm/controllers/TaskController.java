package com.armadillo.crm.controllers;

import com.armadillo.crm.entities.Task;
import com.armadillo.crm.entities.TaskHolder;
import com.armadillo.crm.entities.enums.TaskStatus;
import com.armadillo.crm.mock.taskMock.TasksMock;
import com.armadillo.crm.services.TaskService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TasksMock tasksMock;

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllTasks(){
        ModelAndView modelAndView = new ModelAndView();

        List<Task> tasks = tasksMock.getRandomTasks(1000);
        TaskHolder taskHolder = taskService.getSplitTasks(tasks);

        modelAndView.addObject("tasks", taskHolder);
        modelAndView.setViewName("tasks");

        return modelAndView;
    }
}
