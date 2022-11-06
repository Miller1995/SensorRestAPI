package md.miller1995.springRestAPI.util;

import md.miller1995.springRestAPI.models.Measure;
import md.miller1995.springRestAPI.services.MeasureService;
import md.miller1995.springRestAPI.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasureValidator implements Validator {

    private final MeasureService measureService;
    private final SensorsService sensorsService;

    @Autowired
    public MeasureValidator(MeasureService measureService, SensorsService sensorsService) {
        this.measureService = measureService;
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measure.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measure measure = (Measure) target;

        if (measure.getSensor() == null){
            return;
        }
        if (sensorsService.findByName(measure.getSensor().getName()).isEmpty())
            errors.rejectValue("sensor","", "Sensor doesn't present in database!");
    }
}
