package com.lvcom.practice_app.rider;

import com.lvcom.practice_app.domain.Workingplace;
import com.lvcom.practice_app.repo.WorkingPlaceRepository;
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
public class WorkingRepositoryTest {
    @Autowired
    private WorkingPlaceRepository repo;

    @Test
    void findAllByName_Exists4ItemsWithPlaceName_True() {
        final String name = "place";
        final List<Workingplace> workingplaces = repo.findAllByName(name);
        assertThat(workingplaces)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(4)
                .allMatch(workingplace -> workingplace.getName().equals(name));
    }

    @Test
    void findAllByCity_Exists2ItemsWithChernihivCity_True() {
        final String city = "Chernihiv";
        final List<Workingplace> workingplaces = repo.findAllByCity(city);
        assertThat(workingplaces)
                .isNotNull()
                .hasSizeGreaterThanOrEqualTo(2)
                .allMatch(workingplace -> workingplace.getCity().equals(city));
    }
}
