package com.jns.personalmanagementapp.controller;

import com.jns.personalmanagementapp.dto.TaskCreateDTO;
import com.jns.personalmanagementapp.dto.TaskResponseDTO;
import com.jns.personalmanagementapp.dto.TaskUpdateDTO;
import com.jns.personalmanagementapp.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskCreateDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(taskService.findById(id));
    }

    @GetMapping(("/{user-id}"))
    public ResponseEntity<List<TaskResponseDTO>> findAllByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(taskService.findAllByUserId(userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable UUID id, @RequestBody TaskUpdateDTO dto){
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(taskService.delete(id));
    }

}