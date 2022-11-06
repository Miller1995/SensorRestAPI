package md.miller1995.springRestAPI.controllers;


import md.miller1995.springRestAPI.dto.MeasureDTO;
import md.miller1995.springRestAPI.models.Measure;
import md.miller1995.springRestAPI.services.MeasureService;
import md.miller1995.springRestAPI.util.MeasureValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasuresController {

    private final MeasureService measureService;
    private final MeasureValidator measureValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasuresController(MeasureService measureService, MeasureValidator measureValidator, ModelMapper modelMapper) {
        this.measureService = measureService;
        this.measureValidator = measureValidator;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public List<Measure> findAllMeasures(){
        return measureService.findAllMeasures();
    }

    @GetMapping("/rainyDays")
    public List<Measure> findRainyDay(){
        return measureService.findAllMeasuresWithRainyDays();
    }

    @GetMapping("/rainyDaysCount")
    public Long findRainyDaysCount(){
//        return measureService.findAllMeasuresWithRainyDays().size();                              // size() -> return int
                                    //or
        return measureService.findAllMeasures().stream().filter(Measure::isRaining).count();        //count() -> return long, use filter at method findAllMeasure, we can't create method -
                                                                                                                                                        // -- findAllMeasureWithRainyDays
                                    //or
//        return measureService.findAllMeasuresWithRainyDays().stream().count();                    //count() -> return long    ---- all methods are working
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasure (@RequestBody @Valid MeasureDTO measureDTO,
                                                            BindingResult bindingResult) {

        measureValidator.validate(convertToMeasure(measureDTO), bindingResult);

            if (bindingResult.hasErrors())
                return ResponseEntity.ok(HttpStatus.NOT_ACCEPTABLE);

        measureService.saveMeasure(convertToMeasure(measureDTO));
            return ResponseEntity.ok(HttpStatus.OK);
    }

    private Measure convertToMeasure(MeasureDTO measureDTO) {
        Measure measure = modelMapper.map(measureDTO,Measure.class);           // using ModelMapper updating this method

                        // equals
//        Measure measure = new Measure();
//        measure.setValue(measureDTO.getValue());
//        measure.setRaining(measureDTO.isRaining());
//        measure.setSensor(measureDTO.getSensor());

        return measure;
    }

}
