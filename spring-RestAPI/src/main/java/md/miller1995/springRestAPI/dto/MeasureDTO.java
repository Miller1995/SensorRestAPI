package md.miller1995.springRestAPI.dto;


import md.miller1995.springRestAPI.models.Sensor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MeasureDTO {

    @NotNull(message = "Value shouldn't be null")
    @Size(min = -100, max = 100, message = "Value is between -100 and 100")
    private float value;

    @NotEmpty(message = "Raining shouldn't be empty")
    private boolean raining;

    @NotEmpty(message = "Sensor shouldn't be empty")
    private Sensor sensor;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
