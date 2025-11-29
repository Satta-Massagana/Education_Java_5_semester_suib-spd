package com.suib.spd.suib_spd.service;

import com.suib.spd.suib_spd.model.AuthenticationRecord;
import com.suib.spd.suib_spd.repository.AuthenticationRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationRecordRepository authRepo;

    public List<AuthenticationRecord> getRecentAuthRecords() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "authTimestamp"));
        Page<AuthenticationRecord> page = authRepo.findAll(pageable);
        return page.getContent();
    }
}
