package com.jns.personalmanagementapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(updatable = false)
    private UUID id;
    private String name;
    private String description;
    private BigDecimal progress;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "to_finish_at")
    private LocalDate toFinishAt;
    @Column(name = "finished_at")
    private LocalDate finishedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    @Column(name = "status_id")
    private Byte statusId;
    @Column(name = "user_id")
    private UUID userId;

    public Goal() {
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

    public BigDecimal getProgress() {
        return progress;
    }

    public void setProgress(BigDecimal progress) {
        this.progress = progress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getToFinishAt() {
        return toFinishAt;
    }

    public void setToFinishAt(LocalDate toFinishAt) {
        this.toFinishAt = toFinishAt;
    }

    public LocalDate getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDate finishedAt) {
        this.finishedAt = finishedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Byte getStatusId() {
        return statusId;
    }

    public void setStatusId(Byte statusId) {
        this.statusId = statusId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}