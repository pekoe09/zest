package fi.kumquat.zest.domain;

import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Geography extends BaseModel {

    @NotBlank(message = "Nimi on pakollinen tieto.")
    @Length(max = 100, message = "Nimi voi olla enintään 100 merkkiä pitkä.")
    @Column(unique = true)
    @Field
    private String name;
    @NotBlank(message = "Tyyppi on pakollinen tieto")
    @Length(max = 20, message = "Tyyppi voi olla enintään 20 merkkiä pitkä.")
    @Field
    private String type;
    @ManyToMany
    private List<Geography> parents;
    @ManyToMany(mappedBy = "parents")
    private List<Geography> children;

    public Geography() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Geography> getParents() {
        return parents;
    }

    public List<Geography> AddParent(Geography geography) {
        this.parents.add(geography);
        return parents;
    }

    public List<Geography> RemoveParent(Long id) {
        parents.removeIf((Geography parent) -> parent.id == id);
        return parents;
    }

    public List<Geography> getChildren() {
        return children;
    }

    public List<Geography> AddChild(Geography geography) {
        this.children.add(geography);
        return children;
    }

    public List<Geography> RemoveChild(Long id) {
        children.removeIf((Geography child) -> child.id == id);
        return children;
    }
}
