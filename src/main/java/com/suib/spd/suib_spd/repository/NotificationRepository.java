package com.suib.spd.suib_spd.repository;

import com.suib.spd.suib_spd.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientId(Long recipientId);

    @Query("SELECT n FROM Notification n WHERE n.notifyType = 'URGENT' AND n.incident.status = 'ACTIVE'")
    List<Notification> findUrgentActiveNotifications();
}
