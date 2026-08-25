package com.jns.personalmanagementapp.repository;

import com.jns.personalmanagementapp.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, UUID> {
}