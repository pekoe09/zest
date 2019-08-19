package fi.kumquat.zest.repositories;

import fi.kumquat.zest.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    public Course findByName(String name);
}
