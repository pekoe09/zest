package fi.kumquat.zest.domain;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Beer extends Beverage {

    @NotBlank(message = "Panimo on pakollinen tieto.")
    @Length(max = 100, message = "Panimon nimi voi olla enintään 100 merkkiä pitkä.")
    @Column(unique = true, length = 100)
    @Field(index = Index.YES)
    private String brewery;
    private String country;
    @ManyToOne
    private BeerType beerType;
    @ManyToMany(mappedBy = "beers")
    private List<Recipe> recipes;

    public Beer() {
        this.recipes = new ArrayList<>();
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BeerType getBeerType() {
        return beerType;
    }

    public void setBeerType(BeerType beerType) {
        this.beerType = beerType;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
