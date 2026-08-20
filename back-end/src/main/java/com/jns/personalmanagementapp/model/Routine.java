package com.jns.personalmanagementapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "routines")
public class Routine {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(updatable = false)
    private UUID id;
    private String name;
    private String description;
    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "start_at")
    private LocalDateTime startAt;
    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;
    @Column(name = "recurrence_id")
    private UUID recurrenceId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "goal_id")
    private UUID goalId;
    @Column(name = "status_of_routines_id")
    private Byte statusOfRoutineId;

    public Routine() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getRecurrenceId() {
        return recurrenceId;
    }

    public void setRecurrenceId(UUID recurrenceId) {
        this.recurrenceId = recurrenceId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getGoalId() {
        return goalId;
    }

    public void setGoalId(UUID goalId) {
        this.goalId = goalId;
    }

    public Byte getStatusOfRoutineId() {
        return statusOfRoutineId;
    }

    public void setStatusOfRoutineId(Byte statusOfRoutineId) {
        this.statusOfRoutineId = statusOfRoutineId;
    }
}
