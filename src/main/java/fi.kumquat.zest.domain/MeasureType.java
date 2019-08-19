package fi.kumquat.zest.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MeasureType extends BaseModel {

    @NotBlank(message = "Nimi on pakollinen tieto.")
    @Length(max = 100, message = "Nimi voi olla enintään 100 merkkiä pitkä.")
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "measureType")
    private List<Measure> measures;

    public MeasureType() {
        this.measures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }
}
