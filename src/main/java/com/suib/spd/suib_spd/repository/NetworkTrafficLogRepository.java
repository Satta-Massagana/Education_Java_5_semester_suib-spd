package com.suib.spd.suib_spd.repository;

import com.suib.spd.suib_spd.model.NetworkTrafficLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NetworkTrafficLogRepository extends JpaRepository<NetworkTrafficLog, Long> {
    List<NetworkTrafficLog> findByBytesTransferredGreaterThan(Long bytes);
}
