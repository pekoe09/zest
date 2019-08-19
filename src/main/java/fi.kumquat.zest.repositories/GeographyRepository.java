package fi.kumquat.zest.repositories;

import fi.kumquat.zest.domain.Geography;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeographyRepository extends JpaRepository<Geography, Long> {

    public Geography findByName(String name);
}
