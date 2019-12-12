package com.armadillo.crm.entities;

import com.armadillo.crm.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender gender;
}
