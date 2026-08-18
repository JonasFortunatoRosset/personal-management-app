package com.jns.personalmanagementapp.repository;

import com.jns.personalmanagementapp.model.Recurrence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecurrenceRepository extends JpaRepository<Recurrence, UUID> {
}