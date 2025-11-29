package com.suib.spd.suib_spd.service;

import org.springframework.stereotype.Service;

@Service
public class SziManagementService {
    public String executeSziCommand(String command) {
        return "Команда '" + command + "' успешно выполнена через SSH";
    }
}
