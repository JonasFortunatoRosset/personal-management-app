package com.jns.personalmanagementapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Recurrence {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(updatable = false)
    private UUID id;
    @Column(name = "day_of_month")
    private Byte dayOfMonth;
    @Column(name = "days_of_week")
    private Byte daysOfWeek;
    @Column(name = "weeks_of_month")
    private Byte weeksOfMonth;
    @Column(name = "months_of_year")
    private Short monthsOfYear;
    @Column(name = "deleted_at", insertable = false)
    private LocalDateTime deletedAt;

    public Recurrence() {
    }

    public UUID getId() {
        return id;
    }

    public Byte getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Byte dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Byte getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(Byte daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Byte getWeeksOfMonth() {
        return weeksOfMonth;
    }

    public void setWeeksOfMonth(Byte weeksOfMonth) {
        this.weeksOfMonth = weeksOfMonth;
    }

    public Short getMonthsOfYear() {
        return monthsOfYear;
    }

    public void setMonthsOfYear(Short monthsOfYear) {
        this.monthsOfYear = monthsOfYear;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
