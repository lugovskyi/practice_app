package com.lvcom.practice_app.rider;

import com.lvcom.practice_app.domain.Monitor;
import com.lvcom.practice_app.repo.MonitorRepository;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DBRider
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataSet({"monitor.yml", "pc.yml", "workingplace.yml"})
public class MonitorRepositoryTest {
    @Autowired
    private MonitorRepository repo;

    @Test
    void findAllByLength() {
        final int length = 50;
        final List<Monitor> monitors = repo.findMonitorByLength(length);
        assertThat(monitors)
                .isNotNull()
                .isNotEmpty()
                .allMatch(monitor -> monitor.getLength() == length);

    }
}