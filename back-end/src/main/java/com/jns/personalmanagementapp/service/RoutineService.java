package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.RoutineCreateDTO;
import com.jns.personalmanagementapp.dto.RoutineResponseDTO;
import com.jns.personalmanagementapp.dto.RoutineUpdateDTO;
import com.jns.personalmanagementapp.enums.StatusOfRoutine;
import com.jns.personalmanagementapp.exception.*;
import com.jns.personalmanagementapp.model.Routine;
import com.jns.personalmanagementapp.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final RecurrenceRepository recurrenceRepository;
    private final UserRepository userRepository;
    private final GoalRepository goalRepository;
    private final StatusOfRoutineRepository statusOfRoutineRepository;

    public RoutineService(RoutineRepository routineRepository, RecurrenceRepository recurrenceRepository,
                          UserRepository userRepository, GoalRepository goalRepository,
                          StatusOfRoutineRepository statusOfRoutineRepository)
    {
        this.routineRepository = routineRepository;
        this.recurrenceRepository = recurrenceRepository;
        this.userRepository = userRepository;
        this.goalRepository = goalRepository;
        this.statusOfRoutineRepository = statusOfRoutineRepository;
    }


    public RoutineResponseDTO create(RoutineCreateDTO dto){

        if (dto.recurrenceId() != null) {
            recurrenceRepository.findById(dto.recurrenceId())
                    .orElseThrow(() -> new RecurrenceNotFoundException("Recurrence not found."));
        }
        if (dto.userId() != null) {
            userRepository.findById(dto.userId())
                    .orElseThrow(() -> new UserNotFoundException("User not found."));
        }
        if (dto.goalId() != null) {
            goalRepository.findById(dto.goalId())
                    .orElseThrow(() -> new GoalNotFoundException("Goal not found."));
        }
        if (dto.statusOfRoutinesId() != null) {
            statusOfRoutineRepository.findById(dto.statusOfRoutinesId())
                    .orElseThrow(() -> new StatusOfRoutineNotFound("Status of Routine not found."));
        }

        Routine routine = new Routine();

        routine.setName(dto.name());
        routine.setDescription(dto.description());
        routine.setStartAt(dto.startAt());
        routine.setRecurrenceId(dto.recurrenceId());
        routine.setGoalId(dto.goalId());
        routine.setUserId(dto.userId());
        routine.setStatusOfRoutineId(dto.statusOfRoutinesId());

        routineRepository.save(routine);

        return createRoutineResponseDTO(routine);

    }

    public RoutineResponseDTO findById(UUID id){

        return routineRepository.findById(id)
                .map(this::createRoutineResponseDTO)
                .orElseThrow(() -> new RoutineNotFoundException("Routine not found."));

    }

    public List<RoutineResponseDTO> findAllByUserId(UUID userId){
        return routineRepository
                .findAllByUserId(userId)
                .stream()
                .map(this::createRoutineResponseDTO)
                .toList();
    }

    public RoutineResponseDTO update(UUID id, RoutineUpdateDTO dto){

        Routine routine = routineRepository
                .findById(id)
                .orElseThrow(() -> new RoutineNotFoundException("Routine not found."));

        if (dto.recurrenceId() != null) {
            recurrenceRepository.findById(dto.recurrenceId())
                    .orElseThrow(() -> new RecurrenceNotFoundException("Recurrence not found."));
        }
        if (dto.goalId() != null) {
            goalRepository.findById(dto.goalId())
                    .orElseThrow(() -> new GoalNotFoundException("Goal not found."));
        }
        if (dto.statusOfRoutinesId() != null) {
            statusOfRoutineRepository.findById(dto.statusOfRoutinesId())
                    .orElseThrow(() -> new StatusOfRoutineNotFound("Status of Routine not found."));
        }

        routine.setName(dto.name());
        routine.setDescription(dto.description());
        routine.setStartAt(dto.startAt());
        routine.setRecurrenceId(dto.recurrenceId());
        routine.setGoalId(dto.goalId());
        routine.setStatusOfRoutineId(dto.statusOfRoutinesId());

        routineRepository.save(routine);

        return createRoutineResponseDTO(routine);

    }

    public RoutineResponseDTO delete(UUID id){

        Routine routine = routineRepository
                .findById(id)
                .orElseThrow(() -> new RoutineNotFoundException("Routine not found."));

        routine.setDeletedAt(LocalDateTime.now());
        routine.setStatusOfRoutineId(StatusOfRoutine.CANCELLED.getValue());

        routineRepository.save(routine);

        return createRoutineResponseDTO(routine);

    }

    public RoutineResponseDTO createRoutineResponseDTO(Routine routine){

        return new RoutineResponseDTO(
                routine.getId(),
                routine.getName(),
                routine.getDescription(),
                routine.getCreatedAt(),
                routine.getStartAt(),
                routine.getDeletedAt(),
                routine.getRecurrenceId(),
                routine.getUserId(),
                routine.getGoalId(),
                routine.getStatusOfRoutineId()
        );

    }

}