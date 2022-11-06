package md.miller1995.springRestAPI.repositories;

import md.miller1995.springRestAPI.models.Measure;
import md.miller1995.springRestAPI.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MeasureRepository extends JpaRepository<Measure, Integer> {
        List<Measure> findByRainingTrue();
        Optional<Measure> findBySensor(Sensor sensor);
}
