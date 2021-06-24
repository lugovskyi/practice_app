package com.lvcom.practice_app.service;

import com.lvcom.practice_app.domain.Pc;
import com.lvcom.practice_app.exception.EntityNotFoundException;
import com.lvcom.practice_app.exception.IllegalEntityException;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PcService {
    @NonNull
    Pc save(Pc pc);

    @NonNull
    Pc add(@NonNull Pc pc) throws IllegalEntityException;

    @Transactional
    void delete(@NonNull Pc pc) throws IllegalEntityException, EntityNotFoundException;

    @Transactional
    void deleteById(Long id) throws IllegalEntityException, EntityNotFoundException;

    @NonNull
    List<Pc> getByCpuCount(@NonNull Integer cpuCount);

    @NonNull
    List<Pc> getByCreatedBy(@NonNull String createdBy);

    @NonNull
    List<Pc> getByRamSize(@NonNull Integer ramSize);

    @NonNull
    List<Pc> getByWidth(@NonNull Integer width);

    @NonNull
    List<Pc> getByHeight(@NonNull Integer height);

    @NonNull
    List<Pc> getByLength(@NonNull Integer length);
}
