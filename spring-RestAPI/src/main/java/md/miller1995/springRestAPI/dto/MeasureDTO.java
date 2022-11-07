package md.miller1995.springRestAPI.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


public class MeasureDTO {

    @NotNull
    @Range(min = -100, max = 100)
    private Float value;

    @NotNull
    private Boolean raining;

    @NotNull
    private SensorDTO sensor;

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

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
