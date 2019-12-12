package com.armadillo.crm.entities;

import com.armadillo.crm.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "managers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Manager {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 40)
    private String firstName;

    @Column(nullable = false, length = 40)
    private String lastName;

    @Column
    private Date birthDate;

    @Column(length = 40)
    private Gender gender;

    @Column(nullable = false, length = 40)
    private String jobTitle;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Deal> deals;
}
