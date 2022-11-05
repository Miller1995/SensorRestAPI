package md.miller1995.springRestAPI.repositories;

import md.miller1995.springRestAPI.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {     //  repository that offered ours access to database and worked with database
        Optional<Sensor> findByName(String name);

}
