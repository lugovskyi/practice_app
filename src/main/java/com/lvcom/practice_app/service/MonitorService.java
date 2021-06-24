package com.lvcom.practice_app.service;

import com.lvcom.practice_app.domain.Monitor;
import com.lvcom.practice_app.exception.IllegalEntityException;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MonitorService {

    @NonNull
    Monitor save(Monitor monitor);

    @NonNull
    Monitor add(@NonNull Monitor monitor) throws IllegalEntityException;
}
