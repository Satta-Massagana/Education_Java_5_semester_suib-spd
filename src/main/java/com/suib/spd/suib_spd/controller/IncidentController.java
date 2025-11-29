package com.suib.spd.suib_spd.controller;

import com.suib.spd.suib_spd.model.Incident;
import com.suib.spd.suib_spd.service.IncidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Инциденты")
@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {
    private final IncidentService incidentService;

    @Operation(summary = "Создать инцидент",
            description = "Регистрирует новый инцидент безопасности со статусом NEW")
    @PostMapping
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
        return ResponseEntity.ok(incidentService.createIncident(incident));
    }

    @Operation(summary = "Получить все инциденты",
            description = "Возвращает список всех зарегистрированных инцидентов")
    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidents() {
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }
}
