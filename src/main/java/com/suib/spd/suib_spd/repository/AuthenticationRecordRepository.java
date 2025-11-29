package com.suib.spd.suib_spd.repository;

import com.suib.spd.suib_spd.model.AuthenticationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRecordRepository extends JpaRepository<AuthenticationRecord, Long> {
}
