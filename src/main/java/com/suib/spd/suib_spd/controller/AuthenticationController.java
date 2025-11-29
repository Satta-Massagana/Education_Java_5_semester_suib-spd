package com.suib.spd.suib_spd.controller;

import com.suib.spd.suib_spd.model.AuthenticationRecord;
import com.suib.spd.suib_spd.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Аутентификация", description = "Управление записями аутентификации")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @Operation(summary = "Получить последние записи аутентификации", description = "Возвращает 10 последних попыток входа")
    @GetMapping("/records")
    public ResponseEntity<List<AuthenticationRecord>> getAuthRecords() {
        return ResponseEntity.ok(authService.getRecentAuthRecords());
    }
}
