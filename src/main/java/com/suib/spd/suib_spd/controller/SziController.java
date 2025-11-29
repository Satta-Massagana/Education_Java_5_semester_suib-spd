package com.suib.spd.suib_spd.controller;

import com.suib.spd.suib_spd.service.SziManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "СЗИ", description = "Управление средствами защиты информации через SSH")
@RestController
@RequestMapping("/api/szi")
@RequiredArgsConstructor
public class SziController {
    private final SziManagementService sziService;

    @Operation(summary = "Выполнить команду СЗИ",
            description = "Отправляет SSH команду на сервер СЗИ и возвращает результат")
    @PostMapping("/command")
    public ResponseEntity<String> executeCommand(@RequestBody String command) {
        return ResponseEntity.ok(sziService.executeSziCommand(command));
    }
}
