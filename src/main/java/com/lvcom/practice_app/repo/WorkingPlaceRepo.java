package com.lvcom.practice_app.repo;

import com.lvcom.practice_app.domain.Workingplace;
import org.springframework.data.repository.CrudRepository;

public interface WorkingPlaceRepo extends CrudRepository<Workingplace,Long> {
}
