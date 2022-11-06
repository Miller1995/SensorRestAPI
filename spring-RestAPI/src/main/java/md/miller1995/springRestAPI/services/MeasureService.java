package md.miller1995.springRestAPI.services;

import md.miller1995.springRestAPI.models.Measure;
import md.miller1995.springRestAPI.models.Sensor;
import md.miller1995.springRestAPI.repositories.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasureService {

    private final MeasureRepository measureRepository;
    private final SensorsService sensorsService;


    @Autowired
    public MeasureService(MeasureRepository measureRepository, SensorsService sensorsService) {
        this.measureRepository = measureRepository;
        this.sensorsService = sensorsService;
    }


    public List<Measure> findAllMeasures(){
        return measureRepository.findAll();
    }

    public List<Measure> findAllMeasuresWithRainyDays(){
        return measureRepository.findByRainingTrue();
    }

    public Optional<Measure> findBySensor(Sensor sensor){
        return measureRepository.findBySensor(sensor);
    }

    @Transactional
    public void saveMeasure(Measure measure){
        updateMeasure(measure);
        measureRepository.save(measure);
    }

    public void updateMeasure( Measure measure){

        // we need find sensor from database and set object from Hibernate persistence context ->
        // name of Sensor that get from Json, we need find this name in our database with findByName() and after we set this object in measure
        measure.setSensor(sensorsService.findByName(measure.getSensor().getName()).get());
        measure.setCreateAt(LocalDateTime.now());
    }


}
