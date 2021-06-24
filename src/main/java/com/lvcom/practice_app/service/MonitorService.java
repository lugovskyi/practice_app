package com.lvcom.practice_app.service;

import com.lvcom.practice_app.domain.Monitor;
import com.lvcom.practice_app.exception.EntityNotFoundException;
import com.lvcom.practice_app.exception.IllegalEntityException;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MonitorService {

    @NonNull
    Monitor save(Monitor monitor);

    @NonNull
    Monitor add(@NonNull Monitor monitor) throws IllegalEntityException;

    @Transactional
    void delete(@NonNull Monitor monitor) throws IllegalEntityException, EntityNotFoundException;

    @Transactional
    void deleteById(Long id) throws IllegalEntityException, EntityNotFoundException;

    @NonNull
    List<Monitor> getCreatedBy(@NonNull String createdBy);

    @NonNull
    List<Monitor> getByDisplaySize(@NonNull Integer displaySize);

    @NonNull
    List<Monitor> getByHeight(@NonNull Integer height);

    @NonNull
    List<Monitor> getBylength(@NonNull Integer length);

    @NonNull
    List<Monitor> getByWidth(@NonNull Integer width);

    @NonNull
    List<Monitor> getAll();
}
