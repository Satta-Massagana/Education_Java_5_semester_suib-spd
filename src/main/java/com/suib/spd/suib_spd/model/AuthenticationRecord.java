package com.suib.spd.suib_spd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor
public class AuthenticationRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private LocalDateTime authTimestamp;
    private String authMethod;
    private boolean successFlag;
}
