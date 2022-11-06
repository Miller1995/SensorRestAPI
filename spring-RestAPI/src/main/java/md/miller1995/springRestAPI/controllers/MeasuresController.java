package md.miller1995.springRestAPI.controllers;


import md.miller1995.springRestAPI.dto.MeasureDTO;
import md.miller1995.springRestAPI.models.Measure;
import md.miller1995.springRestAPI.services.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasuresController {

    private final MeasureService measureService;

    @Autowired
    public MeasuresController(MeasureService measureService) {
        this.measureService = measureService;
    }


    @GetMapping
    public List<Measure> findAll(){
        return measureService.findAllMeasures();
    }

    @GetMapping("/rainyDays")
    public List<Measure> findRainyDay(){
        return measureService.findAllMeasuresWithRainyDays();
    }

    @GetMapping("/rainyDaysCount")
    public long findRainyDaysCount(){
//        return measureService.findAllMeasuresWithRainyDays().size();                              // size() -> return int
                                    //or
        return measureService.findAllMeasures().stream().filter(Measure::isRaining).count();        //count() -> return long, use filter at method findAllMeasure, we can't create method -
                                                                                                                                                        // -- findAllMeasureWithRainyDays
                                    //or
//        return measureService.findAllMeasuresWithRainyDays().stream().count();                    //count() -> return long    ---- all methods are working
    }

}
