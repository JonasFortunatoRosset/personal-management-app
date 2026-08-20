package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.GoalCreateDTO;
import com.jns.personalmanagementapp.dto.GoalResponseDTO;
import com.jns.personalmanagementapp.dto.GoalUpdateDTO;
import com.jns.personalmanagementapp.enums.StatusOfGoal;
import com.jns.personalmanagementapp.exception.GoalNotFoundException;
import com.jns.personalmanagementapp.model.Goal;
import com.jns.personalmanagementapp.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public GoalResponseDTO create(GoalCreateDTO dto){

        Goal goal = new Goal();

        goal.setName(dto.name());
        goal.setDescription(dto.description());
        goal.setCreatedAt(LocalDateTime.now());
        goal.setToFinishAt(dto.toFinishAt());
        goal.setStatusId(StatusOfGoal.PENDING.getValue());
        goal.setUserId(dto.userId());

        goalRepository.save(goal);

        return createGoalResponseDTO(goal);

    }

    public GoalResponseDTO findById(UUID id){

        return goalRepository.findById(id)
                .map(this::createGoalResponseDTO)
                .orElseThrow(() -> new GoalNotFoundException("Goal Not Found."));

    }

    public GoalResponseDTO update(UUID id, GoalUpdateDTO dto){

        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new GoalNotFoundException("Goal Not Found."));

        if(dto.name() != null && !dto.name().isBlank()){
            goal.setName(dto.name());
        }
        if(dto.description() != null){
            goal.setDescription(dto.description().isBlank() ? null : dto.description());
        }
        if (dto.toFinishAt() != null){
            goal.setToFinishAt(dto.toFinishAt());
        }

        goalRepository.save(goal);

        return createGoalResponseDTO(goal);

    }

    public GoalResponseDTO deleteById(UUID id){

        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new GoalNotFoundException("Goal Not Found."));

        if (goal.getDeletedAt() == null) {
            goal.setDeletedAt(LocalDateTime.now());
        }

        return createGoalResponseDTO(goal);

    }

    private GoalResponseDTO createGoalResponseDTO(Goal goal){
        return new GoalResponseDTO(
                goal.getId(),
                goal.getName(),
                goal.getDescription(),
                goal.getProgress(),
                goal.getCreatedAt(),
                goal.getToFinishAt(),
                goal.getFinishedAt(),
                goal.getDeletedAt(),
                goal.getStatusId(),
                goal.getUserId()
        );
    }
}