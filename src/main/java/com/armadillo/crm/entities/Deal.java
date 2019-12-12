package com.armadillo.crm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "deals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "manager", insertable = false, updatable = false)
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "customer", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "deal", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
