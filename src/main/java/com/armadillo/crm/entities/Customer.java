package com.armadillo.crm.entities;

import com.armadillo.crm.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 40)
    private String firstName;

    @Column(nullable = false, length = 40)
    private String lastName;

    @Column
    private LocalDate birthDate;

    @Column(length = 40)
    private Gender gender;

    @Column(nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 40)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "company", insertable = false, updatable = false)
    private Company company;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Deal> deals;
}
