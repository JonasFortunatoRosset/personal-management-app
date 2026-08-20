package com.jns.personalmanagementapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_of_routines")
public class StatusOfRoutine {

    @Id
    private Byte id;
    @Column(insertable = false, updatable = false)
    private String name;

    public StatusOfRoutine() {
    }

    public Byte getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}