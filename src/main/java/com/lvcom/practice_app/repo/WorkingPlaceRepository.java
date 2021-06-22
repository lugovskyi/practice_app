package com.lvcom.practice_app.repo;

import com.lvcom.practice_app.domain.Workingplace;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkingPlaceRepository extends CrudRepository<Workingplace,Long> {
    List<Workingplace> find2ItemsByCity(String city);

    List<Workingplace> findAllByName(String name);

    List<Workingplace> find4ItemsByName(String name);

    List<Workingplace> findAllByCity(String city);
}



