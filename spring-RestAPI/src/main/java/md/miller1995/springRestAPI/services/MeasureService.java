package md.miller1995.springRestAPI.services;

import md.miller1995.springRestAPI.models.Measure;
import md.miller1995.springRestAPI.repositories.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasureService {

    private final MeasureRepository measureRepository;


    @Autowired
    public MeasureService(MeasureRepository measureRepository) {
        this.measureRepository = measureRepository;
    }


    public List<Measure> findAllMeasures(){
        return measureRepository.findAll();
    }


}
