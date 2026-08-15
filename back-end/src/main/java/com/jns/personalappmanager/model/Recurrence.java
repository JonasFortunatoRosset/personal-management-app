package com.jns.personalappmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class Recurrence {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;
    private byte day_of_month;
    private byte days_of_week;
    private byte week_of_month;
    private byte months_of_year;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public byte getDay_of_month() {
        return day_of_month;
    }

    public void setDay_of_month(byte day_of_month) {
        this.day_of_month = day_of_month;
    }

    public byte getDays_of_week() {
        return days_of_week;
    }

    public void setDays_of_week(byte days_of_week) {
        this.days_of_week = days_of_week;
    }

    public byte getWeek_of_month() {
        return week_of_month;
    }

    public void setWeek_of_month(byte week_of_month) {
        this.week_of_month = week_of_month;
    }

    public byte getMonths_of_year() {
        return months_of_year;
    }

    public void setMonths_of_year(byte months_of_year) {
        this.months_of_year = months_of_year;
    }
}
