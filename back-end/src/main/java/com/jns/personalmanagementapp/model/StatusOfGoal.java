package com.jns.personalmanagementapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "status_of_goals")
public class StatusOfGoal {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;
    @Column(insertable = false, updatable = false)
    private String name;

    public StatusOfGoal() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}