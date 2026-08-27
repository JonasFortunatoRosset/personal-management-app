package com.jns.personalmanagementapp.controller;

import com.jns.personalmanagementapp.dto.TaskHistoryCreateDTO;
import com.jns.personalmanagementapp.dto.TaskHistoryResponseDTO;
import com.jns.personalmanagementapp.service.TaskHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task-history")
public class TaskHistoryController {

    private final TaskHistoryService taskHistoryService;

    public TaskHistoryController(TaskHistoryService taskHistoryService) {
        this.taskHistoryService = taskHistoryService;
    }

    @PostMapping
    public ResponseEntity<TaskHistoryResponseDTO> create(@RequestBody TaskHistoryCreateDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskHistoryService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskHistoryResponseDTO> findById(@PathVariable UUID id){
        return  ResponseEntity.ok(taskHistoryService.findById(id));
    }

    @GetMapping("/{task-id}")
    public ResponseEntity<List<TaskHistoryResponseDTO>> findAllByTaskId(@PathVariable UUID taskId){
        return  ResponseEntity.ok(taskHistoryService.findAllByTaskId(taskId));
    }

}