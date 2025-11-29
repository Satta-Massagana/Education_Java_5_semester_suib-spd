package com.suib.spd.suib_spd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String passwordHash;
    private String email;
    private LocalDateTime lastLogin;
    private String accountStatus;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRole> userRoles = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AuthenticationRecord> authRecords = new ArrayList<>();
}
