package by.mikita.bialiayeu.server.service.impl;

import by.mikita.bialiayeu.server.dao.TeacherDAO;
import by.mikita.bialiayeu.server.model.Claim;
import by.mikita.bialiayeu.server.model.Teacher;
import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherServiceImpl {

    @Autowired
    private TeacherDAO teacherDAO;
    private ModelMapper modelMapper;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, ModelMapper modelMapper){
        this.teacherDAO = teacherDAO;
        this.modelMapper = modelMapper;
    }

    public List<Teacher> findAllTeacher(){
        return teacherDAO.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public void addTeacher(Teacher teacher){
        teacherDAO.save(teacher);
    }

    public void deleteTeacher(int idTeacher){
        teacherDAO.deleteById(idTeacher);
    }

    public Teacher findTeacherById(int idTeacher){
        Optional<Teacher> teacherOptional = teacherDAO.findById(idTeacher);
        Teacher teacher = teacherOptional.map(u -> modelMapper.map(u, Teacher.class)).get();
        return teacher;
    }

    public List<Teacher> findTeachersBySkill(String skill){
        return teacherDAO.findAllBySkill(skill);
    }

}
