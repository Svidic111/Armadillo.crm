package com.armadillo.crm.mock.personMock;

import com.armadillo.crm.entities.enums.Gender;
import lombok.Data;

public enum FirstNames {
    SARA("Sara", Gender.FEMALE),
    ANDREW("Andrew", Gender.MALE),
    MARK("Mark", Gender.MALE),
    SOFIA("Sofia", Gender.FEMALE),
    DAVID("David", Gender.MALE),
    ALEX("Alex", Gender.MALE),
    DARIA("Daria", Gender.FEMALE),
    JULIA("Julia", Gender.FEMALE),
    MICHAEL("Michael", Gender.MALE),
    EUGENE("Eugene", Gender.MALE),
    SHOWN("Shown", Gender.MALE),
    LARA("Lara", Gender.FEMALE),
    LINCOLN("Lincoln", Gender.MALE);

    private String name;
    private Gender gender;

    FirstNames(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }

    public Gender getGender(){
        return gender;
    }
}
