package com.lvcom.practice_app.repo;

import com.lvcom.practice_app.domain.Monitor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonitorRepository extends CrudRepository<Monitor,Long> {

     List<Monitor> findMonitorByLength(int length);

     List<Monitor> findAllByHeight(int height);

     List<Monitor> findAllByWidth(int width);

     List<Monitor> findAllByLength(Integer length);
}
