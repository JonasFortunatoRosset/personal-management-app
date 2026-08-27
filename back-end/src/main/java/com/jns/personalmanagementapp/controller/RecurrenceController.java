package com.jns.personalmanagementapp.controller;

import com.jns.personalmanagementapp.dto.RecurrenceCreateDTO;
import com.jns.personalmanagementapp.dto.RecurrenceResponseDTO;
import com.jns.personalmanagementapp.dto.RecurrenceUpdateDTO;
import com.jns.personalmanagementapp.service.RecurrenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/recurrences")
public class RecurrenceController {

    private final RecurrenceService recurrenceService;

    public RecurrenceController(RecurrenceService recurrenceService) {
        this.recurrenceService = recurrenceService;
    }

    @PostMapping
    public ResponseEntity<RecurrenceResponseDTO> create(@RequestBody RecurrenceCreateDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(recurrenceService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecurrenceResponseDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(recurrenceService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecurrenceResponseDTO> update(@PathVariable UUID id, @RequestBody RecurrenceUpdateDTO dto){
        return ResponseEntity.ok(recurrenceService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecurrenceResponseDTO> deleteById(@PathVariable UUID id){
        return ResponseEntity.ok(recurrenceService.deleteById(id));
    }
}