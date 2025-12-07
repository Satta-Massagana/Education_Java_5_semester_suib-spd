package com.suib.spd.suib_spd.service;

import com.suib.spd.suib_spd.model.Incident;
import com.suib.spd.suib_spd.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {
    private final IncidentRepository incidentRepo;

    public Incident createIncident(Incident incident) {
        incident.setStatus("NEW");
        incident.setTimestamp(LocalDateTime.now());
        return incidentRepo.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepo.findAll();
    }
}
