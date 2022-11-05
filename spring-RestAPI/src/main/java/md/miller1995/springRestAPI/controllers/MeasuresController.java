package md.miller1995.springRestAPI.controllers;


import md.miller1995.springRestAPI.dto.MeasureDTO;
import md.miller1995.springRestAPI.models.Measure;
import md.miller1995.springRestAPI.services.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
