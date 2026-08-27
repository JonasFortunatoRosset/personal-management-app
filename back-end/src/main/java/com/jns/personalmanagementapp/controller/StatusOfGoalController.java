package com.jns.personalmanagementapp.controller;

import com.jns.personalmanagementapp.dto.StatusOfGoalResponseDTO;
import com.jns.personalmanagementapp.service.StatusOfGoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status-of-goal")
public class StatusOfGoalController {

    private final StatusOfGoalService statusOfGoalService;

    public StatusOfGoalController(StatusOfGoalService statusOfGoalService) {
        this.statusOfGoalService = statusOfGoalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusOfGoalResponseDTO> findById(@PathVariable Byte id){
        return ResponseEntity.ok(statusOfGoalService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StatusOfGoalResponseDTO>> findAll(){
        return ResponseEntity.ok(statusOfGoalService.findAll());
    }

}
