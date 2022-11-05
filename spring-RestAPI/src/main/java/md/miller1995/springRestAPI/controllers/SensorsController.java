package md.miller1995.springRestAPI.controllers;


import md.miller1995.springRestAPI.dto.SensorDTO;
import md.miller1995.springRestAPI.models.Sensor;
import md.miller1995.springRestAPI.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> addSensors(@RequestBody SensorDTO sensorDTO){   //return object with http answer  ->  RequestBody converted json in Sensor


        sensorsService.saveSensors(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);      // return for client -> the message OK (sent HTTP response with empty body and status 200)
    }



    private Sensor convertToSensor(SensorDTO sensorDTO) {    // method is converting object sensorDTO in object sensor
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.getName());
        return sensor;
    }





}
