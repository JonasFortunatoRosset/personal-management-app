package com.jns.personalmanagementapp.service;

import com.jns.personalmanagementapp.dto.RecurrenceCreateDTO;
import com.jns.personalmanagementapp.dto.RecurrenceResponseDTO;
import com.jns.personalmanagementapp.dto.RecurrenceUpdateDTO;
import com.jns.personalmanagementapp.enums.WeekOfMonth;
import com.jns.personalmanagementapp.exception.RecurrenceNotFoundException;
import com.jns.personalmanagementapp.model.Recurrence;
import com.jns.personalmanagementapp.repository.RecurrenceRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Service
public class RecurrenceService {

    private final RecurrenceRepository recurrenceRepository;

    public RecurrenceService(RecurrenceRepository recurrenceRepository) {
        this.recurrenceRepository = recurrenceRepository;
    }

    public RecurrenceResponseDTO create(RecurrenceCreateDTO dto){

        Recurrence recurrence = new Recurrence();

        if (dto.dayOfMonth() >= 1 && dto.dayOfMonth() <= 31){
            recurrence.setDayOfMonth(dto.dayOfMonth());
        } else {
            recurrence.setDayOfMonth(null);
        }

        recurrence.setDaysOfWeek(calculateDaysOfWeek(dto.daysOfWeek()));
        recurrence.setWeeksOfMonth(calculateWeeksOfMonth(dto.weeksOfMonth()));
        recurrence.setMonthsOfYear(calculateMonthsOfYear(dto.monthsOfYear()));

        recurrenceRepository.save(recurrence);

        return createRecurrenceResponseDTO(recurrence);

    }

    public RecurrenceResponseDTO findById(UUID id){
        return recurrenceRepository.findById(id)
                .map(this::createRecurrenceResponseDTO)
                .orElseThrow(() -> new RecurrenceNotFoundException("Recurrence not found."));
    }

    public RecurrenceResponseDTO update(UUID id, RecurrenceUpdateDTO dto){

            Recurrence recurrence = recurrenceRepository.findById(id)
                    .orElseThrow(() -> new RecurrenceNotFoundException("Recurrence not found."));

            if (dto.dayOfMonth() != null) {
                recurrence.setDayOfMonth(dto.dayOfMonth());
            }
            if(dto.daysOfWeek() != null) {
                recurrence.setDaysOfWeek(calculateDaysOfWeek(dto.daysOfWeek()));
            }
            if(dto.weeksOfMonth() != null) {
                recurrence.setWeeksOfMonth(calculateWeeksOfMonth(dto.weeksOfMonth()));
            }
            if(dto.monthsOfYear() != null) {
                recurrence.setMonthsOfYear(calculateMonthsOfYear(dto.monthsOfYear()));
            }

            recurrenceRepository.save(recurrence);

            return createRecurrenceResponseDTO(recurrence);

    }

    public RecurrenceResponseDTO deleteById(UUID id){

        Recurrence recurrence = recurrenceRepository.findById(id)
                .orElseThrow(() -> new RecurrenceNotFoundException("Recurrence not found."));

        if (recurrence.getDeletedAt() == null) {
            recurrence.setDeletedAt(LocalDateTime.now());
        }

        return createRecurrenceResponseDTO(recurrence);

    }


    private Byte calculateDaysOfWeek(List<DayOfWeek> days) {

        if(days.isEmpty()) {
            return null;
        }

        byte mask = 0;

        for (DayOfWeek day : days) {
            int bit = day.getValue() % 7;
            mask |= (byte) (1 << bit);
        }

        return mask;

    }

    private Byte calculateWeeksOfMonth(List<WeekOfMonth> weeks) {

        if(weeks.isEmpty()) {
            return null;
        }

        byte mask = 0;

        for (WeekOfMonth week : weeks){
            mask += week.getValue();
        }

        return mask;

    }

    private Short calculateMonthsOfYear(List<Month> months){

        if(months.isEmpty()) {
            return null;
        }

        short mask = 0;

        for(Month month : months) {
            int bit = month.getValue() % 12;
            mask |= (short) (1 << bit);
        }

        return mask;

    }

    private RecurrenceResponseDTO createRecurrenceResponseDTO(Recurrence recurrence){

        return new RecurrenceResponseDTO(
                recurrence.getId(),
                recurrence.getDayOfMonth(),
                recurrence.getDaysOfWeek(),
                recurrence.getWeeksOfMonth(),
                recurrence.getMonthsOfYear(),
                recurrence.getDeletedAt()
        );
    }

}