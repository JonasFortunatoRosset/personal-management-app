package com.jns.personalmanagementapp.repository;

import com.jns.personalmanagementapp.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoutineRepository extends JpaRepository<Routine, UUID> {
}