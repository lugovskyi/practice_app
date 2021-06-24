package com.lvcom.practice_app.service.impl;

import com.lvcom.practice_app.domain.Monitor;
import com.lvcom.practice_app.exception.IllegalEntityException;
import com.lvcom.practice_app.repo.MonitorRepository;
import com.lvcom.practice_app.service.MonitorService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class MonitorServiceImpl implements MonitorService {
    private final MonitorRepository repo;

    public MonitorServiceImpl(@NonNull final MonitorRepository repo) {
        this.repo = repo;
    }
    @NonNull
    @Override
    public Monitor save(final Monitor monitor){
        return repo.save(monitor);
    }

    @NonNull
    @Override
    public Monitor add(@NonNull final Monitor monitor) throws IllegalEntityException {
        if (monitor.getId() != null) {
            throw new IllegalEntityException("Entity to insert should have null id");
        }

        return save(monitor);
    }
}