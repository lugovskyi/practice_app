package com.lvcom.practice_app.repo;

import com.lvcom.practice_app.domain.WorkingPlace;
import org.springframework.data.repository.CrudRepository;

public interface WorkingPlaceRepo extends CrudRepository<WorkingPlace,Long> {
}
