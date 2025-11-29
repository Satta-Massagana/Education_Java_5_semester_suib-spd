package com.suib.spd.suib_spd.repository;

import com.suib.spd.suib_spd.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findBySeverityLevel(String severity);

    @Query("SELECT e FROM Event e WHERE e.eventType = 'SECURITY' ORDER BY e.eventId DESC")
    List<Event> findRecentSecurityEvents();
}
