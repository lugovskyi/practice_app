package com.lvcom.practice_app.service;

import com.lvcom.practice_app.domain.Workingplace;
import com.lvcom.practice_app.exception.IllegalEntityException;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface WorkingPlaceService {
    @NonNull
    Workingplace save(Workingplace workingplace);

    @NonNull
    Workingplace add(@NonNull Workingplace workingplace) throws IllegalEntityException;
}
