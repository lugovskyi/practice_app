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
@DataSet({"workingplace.yml", "pc.yml", "monitor.yml"})
public class MonitorRepositoryTest {
    @Autowired
    private MonitorRepository repo;

    @Test
    void findAllByHeight_Exists5ItemsWith5Height() {
        final Integer height = 5;
        final List<Monitor> monitors = repo.findAllByHeight(height);
        assertThat(monitors)
                .isNotNull()
                .isNotEmpty()
                .allMatch(monitor -> height.equals(monitor.getHeight()));

    }

    @Test
    void findAllByWidth_Exists5ItemsWith5Width_True() {
        final Integer width = 5;
        final List<Monitor> monitors = repo.findAllByWidth(width);
        assertThat(monitors)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(5)
                .allMatch(monitor -> width.equals(monitor.getWidth()));

    }

    @Test
    void findAllByLength_Exists4ItemsWith50Length_True() {
        final Integer length = 50;
        final List<Monitor> monitors = repo.findAllByLength(length);
        assertThat(monitors)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(4)
                .allMatch(monitor -> length.equals(monitor.getLength()));
    }
}