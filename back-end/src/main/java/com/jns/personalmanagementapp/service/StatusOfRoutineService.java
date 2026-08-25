package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.StatusOfRoutineResponseDTO;
import com.jns.personalmanagementapp.exception.StatusOfRoutineNotFound;
import com.jns.personalmanagementapp.model.StatusOfRoutine;
import com.jns.personalmanagementapp.repository.StatusOfRoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusOfRoutineService {

    private final StatusOfRoutineRepository statusOfRoutineRepository;

    public StatusOfRoutineService(StatusOfRoutineRepository statusOfRoutineRepository) {
        this.statusOfRoutineRepository = statusOfRoutineRepository;
    }

    public StatusOfRoutineResponseDTO findById(Byte id){
        return statusOfRoutineRepository.findById(id)
                .map(this::createStatusOfRoutineResponseDTO)
                .orElseThrow(() -> new StatusOfRoutineNotFound("Status Of Routine Not Found."));

    }

    public List<StatusOfRoutineResponseDTO> findAll(){

        List<StatusOfRoutine> statusOfRoutines = statusOfRoutineRepository.findAll();

        return statusOfRoutines.stream()
                .map(this::createStatusOfRoutineResponseDTO)
                .toList();

    }

    private StatusOfRoutineResponseDTO createStatusOfRoutineResponseDTO(StatusOfRoutine statusOfRoutine){
        return new StatusOfRoutineResponseDTO(statusOfRoutine.getId(), statusOfRoutine.getName());
    }

}
