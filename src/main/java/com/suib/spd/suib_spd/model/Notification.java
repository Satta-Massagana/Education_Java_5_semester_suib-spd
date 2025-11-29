package com.suib.spd.suib_spd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "incidentId")
    private Incident incident;

    private LocalDateTime notifyTimestamp;
    private String notifyType;

    @Column(name = "recipientId")
    private Long recipientId;
}
