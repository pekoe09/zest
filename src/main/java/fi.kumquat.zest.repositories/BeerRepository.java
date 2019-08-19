package fi.kumquat.zest.repositories;

import fi.kumquat.zest.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    public Beer findByName(String name);

    @Query("select distinct(b.brewery) from Beer b")
    public List<String> findBreweries();
}
