package com.lvcom.practice_app.service.impl;

import com.lvcom.practice_app.domain.Pc;
import com.lvcom.practice_app.exception.EntityNotFoundException;
import com.lvcom.practice_app.exception.IllegalEntityException;
import com.lvcom.practice_app.repo.PcRepository;
import com.lvcom.practice_app.service.PcService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PcServiceImpl implements PcService {
    private final PcRepository repo;

    public PcServiceImpl(@NonNull final PcRepository repo) {
        this.repo = repo;
    }
    @NonNull
    @Override
    public Pc save(final Pc pc){
        return repo.save(pc);
    }

    @NonNull
    @Override
    public Pc add(@NonNull final Pc pc) throws IllegalEntityException {
        if (pc.getId() != null) {
            throw new IllegalEntityException("Entity to insert should have null id");
        }

        return save(pc);
    }
    @Transactional
    @Override
    public void delete(@NonNull final Pc pc) throws IllegalEntityException, EntityNotFoundException {
        if (pc.getId() == null) {
            throw new IllegalEntityException("Entity id mustn't be null!");
        }

        final Optional<Pc> byId = repo.findById(pc.getId());
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Entity not found in database!");
        }

        repo.delete(pc);
    }
    @Transactional
    @Override
    public void deleteById(final Long id) throws IllegalEntityException, EntityNotFoundException {
        if (id == null) {
            throw new IllegalEntityException("Entity id mustn't be null!");
        }

        final Optional<Pc> byId = repo.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException("Entity not found in database!");
        }

        repo.deleteById(id);
    }

    @NonNull
    @Override
    public List<Pc> getByCpuCount(@NonNull final Integer cpuCount) {
        return repo.findAllByCpuCount(cpuCount);
    }

    @NonNull
    @Override
    public List<Pc> getByCreatedBy(@NonNull final String createdBy) {
        return repo.findAllByCreatedBy(createdBy);
    }

    @NonNull
    @Override
    public List<Pc> getByRamSize(@NonNull final Integer ramSize) {
        return repo.findAllByRamSize(ramSize);
    }

    @NonNull
    @Override
    public List<Pc> getByWidth(@NonNull final Integer width) {
        return repo.findAllByWidth(width);
    }

    @NonNull
    @Override
    public List<Pc> getByHeight(@NonNull final Integer height) {
        return repo.findAllByHeigth(height);
    }

    @NonNull
    @Override
    public List<Pc> getByLength(@NonNull final Integer length) {
        return repo.findAllByLength(length);
    }
}
