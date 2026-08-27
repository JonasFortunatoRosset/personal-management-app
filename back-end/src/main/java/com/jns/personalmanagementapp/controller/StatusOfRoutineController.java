package com.jns.personalmanagementapp.controller;

import com.jns.personalmanagementapp.dto.StatusOfRoutineResponseDTO;
import com.jns.personalmanagementapp.service.StatusOfRoutineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status-of-routine")
public class StatusOfRoutineController {

    private final StatusOfRoutineService statusOfRoutineService;

    public StatusOfRoutineController(StatusOfRoutineService statusOfRoutineService) {
        this.statusOfRoutineService = statusOfRoutineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusOfRoutineResponseDTO> findById(@PathVariable Byte id){
        return ResponseEntity.ok(statusOfRoutineService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StatusOfRoutineResponseDTO>> findAll(){
        return ResponseEntity.ok(statusOfRoutineService.findAll());
    }
}