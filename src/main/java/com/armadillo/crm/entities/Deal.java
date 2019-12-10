package com.armadillo.crm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    private Date creationDate;
    private Manager manager;
    private Company company;

    private List<Task> tasks;
}
