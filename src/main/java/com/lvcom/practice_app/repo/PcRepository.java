package com.lvcom.practice_app.repo;

import com.lvcom.practice_app.domain.Pc;
import org.springframework.data.repository.CrudRepository;

public interface PcRepository extends CrudRepository<Pc,Long> {
}
