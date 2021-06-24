package com.lvcom.practice_app.service;

import com.lvcom.practice_app.domain.Pc;
import com.lvcom.practice_app.domain.Workingplace;
import com.lvcom.practice_app.exception.EntityNotFoundException;
import com.lvcom.practice_app.exception.IllegalEntityException;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface WorkingPlaceService {
    @NonNull
    Workingplace save(Workingplace workingplace);

    @NonNull
    Workingplace add(@NonNull Workingplace workingplace) throws IllegalEntityException;

    @Transactional
    void delete(@NonNull Workingplace workingplace) throws IllegalEntityException, EntityNotFoundException;

    @Transactional
    void deleteById(Long id) throws IllegalEntityException, EntityNotFoundException;

    @NonNull
    List<Workingplace> getByCity(@NonNull String cpuCount);

    @NonNull
    List<Workingplace> getByCreatedBy(@NonNull String createdBy);

    @NonNull
    List<Workingplace> getByName(@NonNull String name);
}
