package com.armadillo.crm.mock.taskMock;

import com.armadillo.crm.entities.Deal;
import com.armadillo.crm.entities.Manager;
import com.armadillo.crm.entities.Task;
import com.armadillo.crm.entities.enums.TaskStatus;
import com.armadillo.crm.mock.personMock.PersonMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TasksMock {

    @Autowired
    private PersonMock personMock;

    private Random random = new Random();

    public List<Task> getRandomTasks(int quantity){
        List<Task> tasks = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < quantity; i++){
            Task task = getRandomTask(id);
            tasks.add(task);
            id++;
        }

        return tasks;
    }

    public Task getRandomTask(int id){
        Task task = new Task();
        task.setId(id);

        task.setScheduledDate(personMock.getRandomDate((LocalDate.now().getYear()), 2022));
        if(task.getScheduledDate().isBefore(LocalDate.now())){
            task.setStatus(TaskStatus.OUTDATED);
        }else {
            task.setStatus((TaskStatus.values())[random.nextInt(TaskStatus.values().length - 1)]);
        }
        task.setMessage("This is the description of current task. ");

        Deal deal = new Deal();
        deal.setCustomer(personMock.getRandomCustomer());
        deal.setManager(personMock.getRandomManager());

        task.setDeal(deal);

        return task;
    }

}
