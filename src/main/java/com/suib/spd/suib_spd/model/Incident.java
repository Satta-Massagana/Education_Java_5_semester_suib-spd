package com.suib.spd.suib_spd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
public class Incident {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentId;

    private LocalDateTime timestamp;
    private String incidentType;
    private String description;
    private String severity;
    private String status;

    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();
}
