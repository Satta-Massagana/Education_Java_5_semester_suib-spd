package com.suib.spd.suib_spd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
public class NetworkTrafficLog {
    @JsonIgnore
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private LocalDateTime timestamp;
    private String sourceIP;
    private String destinationIP;
    private int sourcePort;
    private int destinationPort;
    private String protocol;
    private long bytesTransferred;

    @JsonIgnore
    @OneToMany(mappedBy = "log", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();
}
