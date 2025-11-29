package com.suib.spd.suib_spd.repository;

import com.suib.spd.suib_spd.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
