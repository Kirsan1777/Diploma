package by.mikita.bialiayeu.server.dao;

import by.mikita.bialiayeu.server.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

}
