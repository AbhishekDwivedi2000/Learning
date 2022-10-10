package com.example.Learning.entity;

import javax.persistence.*;



@MappedSuperclass

public class BaseEntity {

    @Column(name = "isDeleted")
    private  String isDeleted;
    @Column(name = "isActive")
    private String isActive;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "updatedBy")
    private String updatedBy;

    public BaseEntity(String isDeleted, String isActive, String createdBy, String updatedBy) {
        this.isDeleted = isDeleted;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public BaseEntity() {

    }



    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String isActive(String aFalse) {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
