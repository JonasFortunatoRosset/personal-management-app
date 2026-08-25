package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.StatusOfGoalResponseDTO;
import com.jns.personalmanagementapp.exception.StatusOfGoalNotFound;
import com.jns.personalmanagementapp.model.StatusOfGoal;
import com.jns.personalmanagementapp.repository.StatusOfGoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusOfGoalService {

    private final StatusOfGoalRepository statusOfGoalRepository;

    public StatusOfGoalService(StatusOfGoalRepository statusOfGoalRepository) {
        this.statusOfGoalRepository = statusOfGoalRepository;
    }

    public StatusOfGoalResponseDTO findById(Byte id){

        return statusOfGoalRepository.findById(id)
                .map(this::createStatusOfGoalResponseDTO)
                .orElseThrow(() -> new StatusOfGoalNotFound("Status Of Goal Not Found"));
    }

    public List<StatusOfGoalResponseDTO> findAll(){

        List<StatusOfGoal> statusOfGoal = statusOfGoalRepository.findAll();

        return statusOfGoal.stream()
                .map(this::createStatusOfGoalResponseDTO)
                .toList();
    }

    public StatusOfGoalResponseDTO createStatusOfGoalResponseDTO(StatusOfGoal statusOfGoal){
        return new StatusOfGoalResponseDTO(statusOfGoal.getId(), statusOfGoal.getName());
    }
}
