package fi.kumquat.zest.repositories;

import fi.kumquat.zest.domain.DishType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishTypeRepository extends JpaRepository<DishType, Long> {

    public DishType findByName(String name);
}
