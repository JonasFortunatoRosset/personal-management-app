package com.jns.personalmanagementapp.controller;

import com.jns.personalmanagementapp.dto.GoalCreateDTO;
import com.jns.personalmanagementapp.dto.GoalResponseDTO;
import com.jns.personalmanagementapp.dto.GoalUpdateDTO;
import com.jns.personalmanagementapp.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public ResponseEntity<GoalResponseDTO> create(@RequestBody GoalCreateDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(goalService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalResponseDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(goalService.findById(id));
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<GoalResponseDTO> update(@PathVariable UUID id, @RequestBody GoalUpdateDTO dto){
        return ResponseEntity.ok(goalService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GoalResponseDTO> deleteById(@PathVariable UUID id){
        return ResponseEntity.ok(goalService.deleteById(id));
    }
}
