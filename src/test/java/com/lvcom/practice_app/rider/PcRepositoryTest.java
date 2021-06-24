package com.lvcom.practice_app.rider;

import com.lvcom.practice_app.domain.Pc;
import com.lvcom.practice_app.repo.PcRepository;
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
public class PcRepositoryTest {
    @Autowired
    private PcRepository repo;

    @Test
    void findAllByCpuCount_Exists2ItemsWith1CpuCount_True() {
        final Integer cpuCount = 1;
        final List<Pc> pcs = repo.findAllByCpuCount(cpuCount);
        assertThat(pcs)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(2)
                .allMatch(pc -> cpuCount.equals(pc.getCpuCount()) );

    }

    @Test
    void findAllByRamSize_Exists1ItemWith16RamSize_True() {
        final Integer ramSize = 16;
        final List<Pc> pcs = repo.findAllByRamSize(ramSize);
        assertThat(pcs)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(1)
                .allMatch(pc -> ramSize.equals(pc.getRamSize()) );

    }

    @Test
    void findAllByCreatedBy_Exists4ItemsWithAuthorCreatedBy_True() {
        final String createdBy = "author";
        final List<Pc> pcs = repo.findAllByCreatedBy(createdBy);
        assertThat(pcs)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(4)
                .allMatch((pc -> pc.getCreatedBy().equals(createdBy)));
    }
}
