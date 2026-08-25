package com.jns.personalmanagementapp.repository;

import com.jns.personalmanagementapp.model.StatusOfRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOfRoutineRepository extends JpaRepository<StatusOfRoutine, Byte> {
}