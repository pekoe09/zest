package fi.kumquat.zest.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DishType extends BaseModel {

    @NotBlank(message = "Nimi on pakollinen tieto.")
    @Length(max = 100, message = "Nimi voi olla enintään 200 merkkiä pitkä.")
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "dishType")
    private List<Recipe> recipes;

    public DishType() {
        this.recipes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
