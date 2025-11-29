package com.suib.spd.suib_spd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class SecurityAdmin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String name;
    private String contactInfo;
    private String role;
}
