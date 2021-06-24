package com.lvcom.practice_app.service.impl;

import com.lvcom.practice_app.domain.Workingplace;
import com.lvcom.practice_app.exception.EntityNotFoundException;
import com.lvcom.practice_app.exception.IllegalEntityException;
import com.lvcom.practice_app.repo.WorkingPlaceRepository;
import com.lvcom.practice_app.service.WorkingPlaceService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WorkingPlaceServiceImpl implements WorkingPlaceService {
    private final WorkingPlaceRepository repo;

    public WorkingPlaceServiceImpl(@NonNull final WorkingPlaceRepository repo) {
        this.repo = repo;
    }
    @NonNull
    @Override
    public Workingplace save(final Workingplace workingplace){
        return repo.save(workingplace);
    }

    @NonNull
    @Override
    public Workingplace add(@NonNull final Workingplace workingplace) throws IllegalEntityException {
        if (workingplace.getId() != null) {
            throw new IllegalEntityException("Entity to insert should have null id");
        }

        return save(workingplace);
    }

    @Transactional
    @Override
    public void delete(@NonNull final Workingplace workingplace) throws IllegalEntityException, EntityNotFoundException {
        if (workingplace.getId() == null) {
            throw new IllegalEntityException("Entity id mustn't be null!");
        }

        final Optional<Workingplace> byId = repo.findById(workingplace.getId());
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Entity not found in database!");
        }

        repo.delete(workingplace);
    }
    @Transactional
    @Override
    public void deleteById(final Long id) throws IllegalEntityException, EntityNotFoundException {
        if (id == null) {
            throw new IllegalEntityException("Entity id mustn't be null!");
        }

        final Optional<Workingplace> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Entity not found in database!");
        }

        repo.deleteById(id);
    }

    @NonNull
    @Override
    public List<Workingplace> getByCity(@NonNull final String city) {
        return repo.findAllByCity(city);
    }

    @NonNull
    @Override
    public List<Workingplace> getByCreatedBy(@NonNull final String createdBy) {
        return repo.findAllByCreatedBy(createdBy);
    }

    @NonNull
    @Override
    public List<Workingplace> getByName(@NonNull final String name) {
        return repo.findAllByName(name);
    }
}