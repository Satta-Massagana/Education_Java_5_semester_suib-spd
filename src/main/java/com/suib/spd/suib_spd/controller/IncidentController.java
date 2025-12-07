package com.suib.spd.suib_spd.controller;

import com.suib.spd.suib_spd.model.Incident;
import com.suib.spd.suib_spd.service.IncidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@Tag(name = "Инциденты")
@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class IncidentController {
    private final IncidentService incidentService;

    @PostMapping
    @Operation(
            summary = "Создать инцидент",
            description = "Регистрирует новый инцидент безопасности",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                {
                  "incidentType": "DDoS",
                  "description": "Распределенная атака на API", 
                  "severity": "CRITICAL"
                }
                """
                            )
                    )
            )
    )
    public ResponseEntity<Incident> createIncident(@RequestBody Map<String, String> data) {
        Incident incident = new Incident();
        incident.setIncidentType(data.get("incidentType"));
        incident.setDescription(data.get("description"));
        incident.setSeverity(data.get("severity"));
        incident.setNotifications(new ArrayList<>());
        return ResponseEntity.ok(incidentService.createIncident(incident));
    }

    @Operation(summary = "Получить все инциденты",
            description = "Возвращает список всех зарегистрированных инцидентов")
    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidents() {
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }
}
