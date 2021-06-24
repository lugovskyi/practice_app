package com.lvcom.practice_app.service.impl;

import com.lvcom.practice_app.domain.Monitor;
import com.lvcom.practice_app.exception.EntityNotFoundException;
import com.lvcom.practice_app.exception.IllegalEntityException;
import com.lvcom.practice_app.repo.MonitorRepository;
import com.lvcom.practice_app.service.MonitorService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public void delete(@NonNull final Monitor monitor) throws IllegalEntityException, EntityNotFoundException {
        if (monitor.getId() == null) {
            throw new IllegalEntityException("Entity id mustn't be null!");
        }

        final Optional<Monitor> byId = repo.findById(monitor.getId());
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Entity not found in database!");
        }

        repo.delete(monitor);
    }
    @Transactional
    @Override
    public void deleteById(final Long id) throws IllegalEntityException, EntityNotFoundException {
        if (id == null) {
            throw new IllegalEntityException("Entity id mustn't be null!");
        }

        final Optional<Monitor> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Entity not found in database!");
        }

        repo.deleteById(id);
    }

    @NonNull
    @Override
    public List<Monitor> getCreatedBy(@NonNull final String createdBy) {
        return repo.findAllByCreatedBy(createdBy);
    }

    @NonNull
    @Override
    public List<Monitor> getByDisplaySize(@NonNull final Integer displaySize) {
        return repo.findAllByDisplaySize(displaySize);
    }

    @NonNull
    @Override
    public List<Monitor> getByHeight(@NonNull final Integer height) {
        return repo.findAllByHeight(height);
    }

    @NonNull
    @Override
    public List<Monitor> getBylength(@NonNull final Integer length) {
        return repo.findAllByLength(length);
    }

    @NonNull
    @Override
    public List<Monitor> getByWidth(@NonNull final Integer width) {
        return repo.findAllByWidth(width);
    }

    @NonNull
    @Override
    public List<Monitor> getAll() {
        return (List<Monitor>) repo.findAll();
    }
}