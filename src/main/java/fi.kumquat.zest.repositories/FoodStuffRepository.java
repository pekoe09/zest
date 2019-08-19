package fi.kumquat.zest.repositories;

import fi.kumquat.zest.domain.Foodstuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodStuffRepository extends JpaRepository<Foodstuff, Long> {

    public Foodstuff findByName(String name);
}
