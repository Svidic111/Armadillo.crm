package com.armadillo.crm.entities;

import lombok.Data;
import java.util.List;

@Data
public class TaskHolder {
    private List<Task> outdatedTasks;
    private List<Task> todayTasks;
    private List<Task> otherTasks;
}
