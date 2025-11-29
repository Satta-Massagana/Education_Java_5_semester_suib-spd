package com.suib.spd.suib_spd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String eventType;
    private String eventDescription;
    private String severityLevel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "logId")
    private NetworkTrafficLog log;
}
