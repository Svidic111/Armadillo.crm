package com.armadillo.crm.entities.enums;

public enum TaskStatus {
    NEW("New"),
    DONE("Done"),
    CANCELED("Canceled"),
    OUTDATED("Outdated");

    private String status;

    TaskStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
