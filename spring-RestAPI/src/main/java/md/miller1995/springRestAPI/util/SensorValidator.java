package md.miller1995.springRestAPI.util;

import md.miller1995.springRestAPI.models.Sensor;
import md.miller1995.springRestAPI.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {
    private final SensorsService sensorsService;


    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {          // --> for which class this validator refers
        return Sensor.class.equals(clazz);              // return true if sensor == this.clazz
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        // see, if sensor with "some name" == target  is in database
        // for that is it necessary call database

        if (sensorsService.findByName(sensor.getName()).isPresent())                  // verified if in database is name==name(target)
            errors.rejectValue("name", "", "This name is already taken");

    }
}
