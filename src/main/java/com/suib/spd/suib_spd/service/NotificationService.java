package com.suib.spd.suib_spd.service;

import com.suib.spd.suib_spd.model.SecurityAdmin;
import com.suib.spd.suib_spd.repository.SecurityAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private SecurityAdminRepository adminRepo;

    public List<SecurityAdmin> getAdminsForNotification() {
        return adminRepo.findAll();
    }
}
