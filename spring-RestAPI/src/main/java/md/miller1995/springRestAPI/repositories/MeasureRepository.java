package md.miller1995.springRestAPI.repositories;

import md.miller1995.springRestAPI.models.Measure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MeasureRepository extends JpaRepository<Measure, Integer> {
        List<Measure> findByRainingTrue();
}
