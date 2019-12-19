package com.armadillo.crm.entities;

import com.armadillo.crm.entities.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Date creationDate;

    @Column
    private Date scheduledDate;

    @Column
    private TaskStatus status;

    @Column
    private String message;

    @ManyToOne
    @JoinColumn(name = "deal", insertable = false, updatable = false)
    private Deal deal;
}
