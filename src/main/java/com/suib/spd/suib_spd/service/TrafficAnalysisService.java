package com.suib.spd.suib_spd.service;

import com.suib.spd.suib_spd.model.Event;
import com.suib.spd.suib_spd.model.NetworkTrafficLog;
import com.suib.spd.suib_spd.repository.EventRepository;
import com.suib.spd.suib_spd.repository.NetworkTrafficLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrafficAnalysisService {
    private final NetworkTrafficLogRepository trafficRepo;
    private final EventRepository eventRepo;

    public NetworkTrafficLog logTraffic(NetworkTrafficLog log) {
        log.setTimestamp(LocalDateTime.now());

        Event event = new Event();
        event.setEventType("TRAFFIC_LOG");
        event.setEventDescription("Сетевой трафик: " + log.getSourceIP() + " -> " + log.getDestinationIP());
        event.setSeverityLevel(log.getBytesTransferred() > 1000000 ? "HIGH" : "LOW");
        event.setLog(log);

        log.getEvents().add(event);

        return trafficRepo.save(log);
    }

    public List<NetworkTrafficLog> getSuspiciousTraffic() {
        return trafficRepo.findByBytesTransferredGreaterThan(1000000L);
    }
}
