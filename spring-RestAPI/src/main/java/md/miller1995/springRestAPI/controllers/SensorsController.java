package md.miller1995.springRestAPI.controllers;


import md.miller1995.springRestAPI.models.Sensor;
import md.miller1995.springRestAPI.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                 // equals --> @Controller + @ResponseBody for all method and all method from this controller return json but not (html etc.)
@RequestMapping("/sensors")     // all methods in this controller have address "/sensor"
public class SensorsController {

    private final SensorsService sensorsService;          // injection sensorService with Spring

    @Autowired
    public SensorsController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @GetMapping()
    public List<Sensor> getSensors(){
        return sensorsService.findAllSensors();         // return List of objects class Sensor and Jackson automatic is converting this objects to JSON
    }





}
