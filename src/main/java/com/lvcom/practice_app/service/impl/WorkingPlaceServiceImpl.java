package com.lvcom.practice_app.service.impl;

import com.lvcom.practice_app.domain.Workingplace;
import com.lvcom.practice_app.exception.IllegalEntityException;
import com.lvcom.practice_app.repo.WorkingPlaceRepository;
import com.lvcom.practice_app.service.WorkingPlaceService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

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
}