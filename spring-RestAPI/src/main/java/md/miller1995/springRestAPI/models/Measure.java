package md.miller1995.springRestAPI.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Measure")
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    @NotNull
    @Range(min = -100, max = 100)
    private Float value;

    @Column(name = "raining")
    @NotNull
    private Boolean raining;                // use class Boolean but not primitive boolean, because we want (raining = null) --> and primitive boolean doesn't permit

    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    @NotNull
    private Sensor sensor;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime createAt;


    public Measure(){}

    public Measure(Float value, Boolean raining, Sensor sensor, LocalDateTime createAt) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
        this.createAt = createAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean getRaining() {
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
