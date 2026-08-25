package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.TaskCreateDTO;
import com.jns.personalmanagementapp.dto.TaskResponseDTO;
import com.jns.personalmanagementapp.dto.TaskUpdateDTO;
import com.jns.personalmanagementapp.exception.GoalNotFoundException;
import com.jns.personalmanagementapp.exception.RoutineNotFoundException;
import com.jns.personalmanagementapp.exception.TaskNotFoundException;
import com.jns.personalmanagementapp.exception.UserNotFoundException;
import com.jns.personalmanagementapp.model.Task;
import com.jns.personalmanagementapp.repository.GoalRepository;
import com.jns.personalmanagementapp.repository.RoutineRepository;
import com.jns.personalmanagementapp.repository.TaskRepository;
import com.jns.personalmanagementapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final GoalRepository goalRepository;
    private final RoutineRepository routineRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, GoalRepository goalRepository, RoutineRepository routineRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.goalRepository = goalRepository;
        this.routineRepository = routineRepository;
    }

    public TaskResponseDTO create(TaskCreateDTO dto){

        if (dto.userId() != null){
            userRepository.findById(dto.userId())
                    .orElseThrow(() -> new UserNotFoundException("User not found."));
        }
        if (dto.goalId() != null){
            goalRepository.findById(dto.goalId())
                    .orElseThrow(() -> new GoalNotFoundException("Goal not found."));
        }
        if (dto.routineId() != null){
            routineRepository.findById(dto.routineId())
                    .orElseThrow(() -> new RoutineNotFoundException("Routine not found."));
        }

        Task task = new Task();

        task.setName(dto.name());
        task.setDescription(dto.description());
        task.setAllowsMultipleCompletions(dto.allowsMultipleCompletions());
        task.setCreatedAt(LocalDateTime.now());
        task.setUserId(dto.userId());
        task.setGoalId(dto.goalId());
        task.setRoutineId(dto.routineId());

        taskRepository.save(task);

        return createTaskResponseDTO(task);

    }

    public TaskResponseDTO findById(UUID id){

        return taskRepository
                .findById(id)
                .map(this::createTaskResponseDTO)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

    }

    public List<TaskResponseDTO> findAllByUserId(UUID id){
        return taskRepository.findAllByUserId(id)
                .stream()
                .map(this::createTaskResponseDTO)
                .toList();
    }

    public TaskResponseDTO update(UUID id, TaskUpdateDTO dto){

        if (dto.goalId() != null){
            goalRepository.findById(dto.goalId())
                    .orElseThrow(() -> new GoalNotFoundException("Goal not found."));
        }
        if (dto.routineId() != null){
            routineRepository.findById(dto.routineId())
                    .orElseThrow(() -> new RoutineNotFoundException("Routine not found."));
        }

        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found."));

        task.setName(dto.name());
        task.setDescription(dto.description());
        task.setGoalId(dto.goalId());
        task.setRoutineId(dto.routineId());

        taskRepository.save(task);

        return createTaskResponseDTO(task);

    }

    public TaskResponseDTO delete(UUID id){

        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found."));
        task.setDeletedAt(LocalDateTime.now());
        taskRepository.save(task);

        return createTaskResponseDTO(task);

    }

    public TaskResponseDTO createTaskResponseDTO(Task task){
        return new TaskResponseDTO(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.isAllowsMultipleCompletions(),
                task.getCreatedAt(),
                task.getDeletedAt(),
                task.getUserId(),
                task.getGoalId(),
                task.getRoutineId()
        );
    }

}