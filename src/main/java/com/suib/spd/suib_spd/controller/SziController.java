package com.suib.spd.suib_spd.controller;

import com.suib.spd.suib_spd.service.SziManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "СЗИ")
@RestController
@RequestMapping("/api/szi")
@RequiredArgsConstructor
public class SziController {

    private final SziManagementService sziService;

    @Operation(summary = "Выполнить SSH команду",
            description = "Подключиться к устройству по SSH и выполнить команду")
    @PostMapping("/command")
    public ResponseEntity<String> executeCommand(
            @RequestBody
            @Schema(description = "Параметры SSH подключения",
                    example = """
                        {
                          "host": "10.0.0.10",
                          "port": 2222,
                          "username": "admin",
                          "password": "pass",
                          "command": "ip address print, ip address add interface=lo address=10.1.1.1/32"
                        }
                        """)
            Map<String, Object> request) {

        // Извлечение параметров
        String host = (String) request.get("host");
        Integer portObj = request.get("port") != null ? ((Number) request.get("port")).intValue() : 22;
        String username = (String) request.get("username");
        String password = (String) request.get("password");
        String command = (String) request.get("command");

        // Проверка обязательных полей
        if (host == null || username == null || password == null || command == null) {
            return ResponseEntity.badRequest()
                    .body("Отсутствуют обязательные параметры: host, username, password, command");
        }

        String output = sziService.executeSziCommand(host, portObj, username, password, command);
        return ResponseEntity.ok(output);
    }
}

