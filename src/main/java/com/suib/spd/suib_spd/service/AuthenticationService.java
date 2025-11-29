package com.suib.spd.suib_spd.service;

import com.suib.spd.suib_spd.model.AuthenticationRecord;
import com.suib.spd.suib_spd.repository.AuthenticationRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationRecordRepository authRepo;

    public List<AuthenticationRecord> getRecentAuthRecords() {
        return authRepo.findAll(Sort.by(Sort.Direction.DESC, "authTimestamp"));
    }
}
