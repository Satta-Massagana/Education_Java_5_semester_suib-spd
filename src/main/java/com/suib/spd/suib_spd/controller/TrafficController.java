package com.suib.spd.suib_spd.controller;

import com.suib.spd.suib_spd.model.NetworkTrafficLog;
import com.suib.spd.suib_spd.service.TrafficAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Трафик", description = "Мониторинг сетевого трафика и анализ подозрительной активности")
@RestController
@RequestMapping("/api/traffic")
@RequiredArgsConstructor
public class TrafficController {
    private final TrafficAnalysisService trafficService;

    @Operation(summary = "Записать сетевой трафик",
            description = "Сохраняет лог сетевого соединения в базу данных")
    @PostMapping("/log")
    public ResponseEntity<NetworkTrafficLog> logTraffic(@RequestBody NetworkTrafficLog log) {
        return ResponseEntity.ok(trafficService.logTraffic(log));
    }

    @Operation(summary = "Получить подозрительный трафик",
            description = "Возвращает трафик с объемом > 1MB (возможные атаки)")
    @GetMapping("/suspicious")
    public ResponseEntity<List<NetworkTrafficLog>> getSuspiciousTraffic() {
        return ResponseEntity.ok(trafficService.getSuspiciousTraffic());
    }
}
