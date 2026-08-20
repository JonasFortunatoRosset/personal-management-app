package com.jns.personalmanagementapp.repository;

import com.jns.personalmanagementapp.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, UUID> {
}