package com.lvcom.practice_app.service.impl;

import com.lvcom.practice_app.domain.Pc;
import com.lvcom.practice_app.exception.IllegalEntityException;
import com.lvcom.practice_app.repo.PcRepository;
import com.lvcom.practice_app.service.PcService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

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
}
