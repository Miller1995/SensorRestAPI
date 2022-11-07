package md.miller1995.springRestAPI.controllers;


import md.miller1995.springRestAPI.dto.SensorDTO;
import md.miller1995.springRestAPI.models.Sensor;
import md.miller1995.springRestAPI.services.SensorsService;
import md.miller1995.springRestAPI.util.ErrorResponse;
import md.miller1995.springRestAPI.util.MeasureAndSensorInvalidInputException;
import md.miller1995.springRestAPI.util.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static md.miller1995.springRestAPI.util.ErrorForClient.returnErrorsToClient;

@RestController                 // equals --> @Controller + @ResponseBody for all method and all method from this controller return json but not (html etc.)
@RequestMapping("/sensors")     // all methods in this controller have address "/sensor"
public class SensorsController {

    private final SensorsService sensorsService;          // injection sensorService with Spring
    private final SensorValidator sensorValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorsController(SensorsService sensorsService, SensorValidator sensorValidator, ModelMapper modelMapper) {
        this.sensorsService = sensorsService;
        this.sensorValidator = sensorValidator;
        this.modelMapper = modelMapper;
    }


    @GetMapping()
    public List<Sensor> getSensors(){
        return sensorsService.findAllSensors();         // return List of objects class Sensor and Jackson automatic is converting this objects to JSON
    }


    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> addSensors(@RequestBody @Valid SensorDTO sensorDTO,              //return object with http answer  ->  RequestBody converted json in Sensor
                                                 BindingResult bindingResult){

        sensorValidator.validate(convertToSensor(sensorDTO), bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);


        sensorsService.saveSensors(convertToSensor(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK);      // return for client -> the message OK (sent HTTP response with empty body and status 200)
    }


    // method is converting object sensorDTO in object sensor
    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);

                    //equals
//        Sensor sensor = new Sensor();
//        sensor.setName(sensorDTO.getName());
//        return sensor;
    }


    // catch exception and return Json with errors
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException (MeasureAndSensorInvalidInputException exception){  // catch exception MeasureAndSensorInvalidInputException f
                                                                                                                // rom returnErrorsToClient(bindingResult);
       ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), System.currentTimeMillis());
       return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }


}
