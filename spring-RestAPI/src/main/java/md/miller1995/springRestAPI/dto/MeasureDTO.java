package md.miller1995.springRestAPI.dto;


import md.miller1995.springRestAPI.models.Sensor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


public class MeasureDTO {

    @NotNull
    @Range(min = -100, max = 100)
    private Float value;

    @NotNull
    private Boolean raining;

    @NotNull
    private Sensor sensor;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
