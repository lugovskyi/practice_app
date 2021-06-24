package com.lvcom.practice_app.service;

import com.lvcom.practice_app.domain.Pc;
import com.lvcom.practice_app.exception.IllegalEntityException;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PcService {
    @NonNull
    Pc save(Pc pc);

    @NonNull
    Pc add(@NonNull Pc pc) throws IllegalEntityException;
}
