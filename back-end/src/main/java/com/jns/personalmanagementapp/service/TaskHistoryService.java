package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.TaskHistoryCreateDTO;
import com.jns.personalmanagementapp.dto.TaskHistoryResponseDTO;
import com.jns.personalmanagementapp.exception.TaskHistoryNotFoundException;
import com.jns.personalmanagementapp.model.TaskHistory;
import com.jns.personalmanagementapp.repository.TaskHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskHistoryService {

    private final TaskHistoryRepository taskHistoryRepository;

    public TaskHistoryService(TaskHistoryRepository taskHistoryRepository) {
        this.taskHistoryRepository = taskHistoryRepository;
    }

    public TaskHistoryResponseDTO create(TaskHistoryCreateDTO dto){

        TaskHistory taskHistory = new TaskHistory();

        taskHistory.setScheduledFor(dto.scheduledFor());
        taskHistory.setCompletedAt(dto.completedAt());
        taskHistory.setTaskId(dto.taskId());

        taskHistoryRepository.save(taskHistory);

        return createTaskHistoryResponseDTO(taskHistory);

    }

    public TaskHistoryResponseDTO findById(UUID id){

        return taskHistoryRepository.findById(id)
                .map(this::createTaskHistoryResponseDTO)
                .orElseThrow(() -> new TaskHistoryNotFoundException("TaskHistory Not Found."));
    }

    public List<TaskHistoryResponseDTO> findAllByTaskId(UUID taskId) {
        return taskHistoryRepository.findAllByTaskId(taskId)
                .stream()
                .map(this::createTaskHistoryResponseDTO)
                .toList();
    }

    private TaskHistoryResponseDTO createTaskHistoryResponseDTO(TaskHistory taskHistory){
        return new TaskHistoryResponseDTO(
            taskHistory.getId(),
            taskHistory.getScheduledFor(),
            taskHistory.getCompletedAt(),
            taskHistory.getTaskId()
        );
    }
}
