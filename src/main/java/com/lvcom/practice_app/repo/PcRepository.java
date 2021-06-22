package com.lvcom.practice_app.repo;

import com.lvcom.practice_app.domain.Pc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PcRepository extends CrudRepository<Pc,Long> {
    List<Pc> findAllByCpuCount(int cpuCount);

    List<Pc> findAllByRamSize(Integer ramSize);

    List<Pc> findAllByCreatedBy(String createdBy);
}
