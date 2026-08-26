package com.jns.personalmanagementapp.controller;

import com.jns.personalmanagementapp.dto.RoutineCreateDTO;
import com.jns.personalmanagementapp.dto.RoutineResponseDTO;
import com.jns.personalmanagementapp.dto.RoutineUpdateDTO;
import com.jns.personalmanagementapp.service.RoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/routines")
public class RoutineController {

    private final RoutineService routineService;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @PostMapping
    public ResponseEntity<RoutineResponseDTO> create(@RequestBody RoutineCreateDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(routineService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineResponseDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(routineService.findById(id));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<RoutineResponseDTO>> findAllByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(routineService.findAllByUserId(userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoutineResponseDTO> update(@PathVariable UUID id, @RequestBody RoutineUpdateDTO dto){
        return ResponseEntity.ok(routineService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoutineResponseDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(routineService.delete(id));
    }

}