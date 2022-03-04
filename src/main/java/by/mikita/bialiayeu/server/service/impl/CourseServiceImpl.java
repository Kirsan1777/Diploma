package by.mikita.bialiayeu.server.service.impl;


import by.mikita.bialiayeu.server.dao.CourseDAO;
import by.mikita.bialiayeu.server.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseServiceImpl /* implements BookService */{
    private CourseDAO courseDAO;
    private ModelMapper modelMapper;
    public CourseServiceImpl(){

    }

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO, ModelMapper modelMapper){
        this.courseDAO = courseDAO;
        this.modelMapper = modelMapper;
    }

    public Course findCourseById(int idCourse){
        Optional<Course> courseOptional = courseDAO.findById(idCourse);
        Course course = courseOptional.map( c -> modelMapper.map(c, Course.class)).get();
        return course;
    }
}
