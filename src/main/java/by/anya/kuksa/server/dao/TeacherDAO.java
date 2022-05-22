package by.anya.kuksa.server.dao;

import by.anya.kuksa.server.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherDAO extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor<Teacher> {

    List<Teacher> findAllBySkill(@Param("skill") String skill);

}
