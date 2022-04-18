package by.mikita.bialiayeu.server.dao;

import by.mikita.bialiayeu.server.model.Course;
import by.mikita.bialiayeu.server.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherDAO extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor<Teacher> {
}
