package com.suib.spd.suib_spd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incidentId")
    @JsonBackReference
    private Incident incident;

    private LocalDateTime notifyTimestamp;
    private String notifyType;

    @Column(name = "recipientId")
    private Long recipientId;
}
