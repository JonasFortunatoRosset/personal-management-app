package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.repository.RoutineRepository;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }


}