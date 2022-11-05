package md.miller1995.springRestAPI.services;

import md.miller1995.springRestAPI.models.Sensor;
import md.miller1995.springRestAPI.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void saveSensors(Sensor sensor){           // save object class Sensor in database
        sensorsRepository.save(sensor);
    }

    public Optional<Sensor> findByName(String name){
        return sensorsRepository.findByName(name);
    }




}
