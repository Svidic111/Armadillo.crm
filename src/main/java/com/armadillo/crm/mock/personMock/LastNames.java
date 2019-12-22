package com.armadillo.crm.mock.personMock;

public enum LastNames {
    MARTSUN("Martsun"),
    GORDON("Gordon"),
    PITT("Pitt"),
    JOHNSON("Johnson"),
    ALLY("Ally"),
    JACKSON("Jackson"),
    SCOFIELD("Scofield"),
    JOLLY("Jolly");

    private String lastName;

    LastNames(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }
}
