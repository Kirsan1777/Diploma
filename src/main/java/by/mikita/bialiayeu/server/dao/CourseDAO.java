package by.mikita.bialiayeu.server.dao;

import by.mikita.bialiayeu.server.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

    List<Course> findAllByNameCourse(@Param("name_course") String nameCourse);
    List<Course> findAllByTypeOfCourse(@Param("type_of_course") String nameCourse);

}
