package com.jns.personalmanagementapp.repository;

import com.jns.personalmanagementapp.model.StatusOfGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOfGoalRepository extends JpaRepository<StatusOfGoal, Byte> {
}