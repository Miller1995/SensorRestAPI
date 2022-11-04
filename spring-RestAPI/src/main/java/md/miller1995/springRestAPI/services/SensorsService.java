package md.miller1995.springRestAPI.services;

import md.miller1995.springRestAPI.models.Sensor;
import md.miller1995.springRestAPI.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;        // injection sensorsRepository for allows access at method from JPA

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }


    public List<Sensor> findAllSensors(){              // find all sensors from database and return its
        return sensorsRepository.findAll();
    }


}
