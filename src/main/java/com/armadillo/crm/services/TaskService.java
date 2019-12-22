package com.armadillo.crm.services;

import com.armadillo.crm.entities.Task;
import com.armadillo.crm.entities.TaskHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskService {
    public TaskHolder getSplitTasks(List<Task> tasks){
        TaskHolder taskHolder = new TaskHolder();

        List<Task> outdatedTasks = tasks.stream()
                .filter(t -> t.getScheduledDate()
                        .isBefore(LocalDate.now())).collect(Collectors.toList());

        List<Task> todayTasks = tasks.stream()
                .filter(t -> t.getScheduledDate()
                        .isEqual(LocalDate.now())).collect(Collectors.toList());

        List<Task> otherTasks = tasks.stream()
                .filter(t -> t.getScheduledDate()
                        .isAfter(LocalDate.now())).collect(Collectors.toList());

        taskHolder.setOutdatedTasks(outdatedTasks);
        taskHolder.setTodayTasks(todayTasks);
        taskHolder.setOtherTasks(otherTasks);

        return taskHolder;
    }
}
