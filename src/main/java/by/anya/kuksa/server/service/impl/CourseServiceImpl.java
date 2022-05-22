package by.anya.kuksa.server.service.impl;


import by.anya.kuksa.server.dao.CourseDAO;
import by.anya.kuksa.server.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
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

    public List<Course> findAllCourses(){
        List<Course> courses = courseDAO.findAll(Sort.by(Sort.Order.desc("id")));
        return courses;
    }

    public List<Course> findAllCoursesByName(String nameCourse){
        List<Course> courses = courseDAO.findAllByNameCourseContaining(nameCourse);
        return courses;
    }

    public Course findCourseById(int idCourse){
        Optional<Course> courseOptional = courseDAO.findById(idCourse);
        Course course = courseOptional.map( c -> modelMapper.map(c, Course.class)).get();
        return course;
    }

    public List<Course> findCourseByType(String typeOfCourse){
        List<Course> course = courseDAO.findAllByTypeOfCourse(typeOfCourse);
        return course;
    }

    public void addNewCourse(Course course){
        course.setPhotoReference(setBasicImage(course.getTypeOfCourse()));
        courseDAO.save(course);
    }

    public void deleteCourseById(int idCourse){
        courseDAO.deleteById(idCourse);
    }

    public void updateAllCourseInfo(Course course){
        /*Get info about course and save it?*/
        courseDAO.save(course);
    }

    public void updateCourseDescriptionById(int idCourse, String newDescription){
        Optional<Course> courseOptional = courseDAO.findById(idCourse);
        Course course = courseOptional.map( c -> modelMapper.map(c, Course.class)).get();
        course.setDescription(newDescription);
        courseDAO.save(course);
    }

    public void updatePhotoById(int idCourse, String newPhoto){
        Optional<Course> courseOptional = courseDAO.findById(idCourse);
        Course course = courseOptional.map( c -> modelMapper.map(c, Course.class)).get();
        course.setPhotoReference(newPhoto);
        courseDAO.save(course);
    }

    public List<Course> findAllByFilter(String type, String continuance, double price){
        return courseDAO.findAllByTypeOfCourseAndContinuanceAndCostIsLessThan(type, continuance, price);
    }

    private String setBasicImage(String type){
        String basicImage = "";
        switch (type){
            case "Java": basicImage = "java.jpg";
                break;
            case "JavaScript": basicImage = "js.jpg";
                break;
            case "QA": basicImage = "QA.jpg";
                break;
            case "Design": basicImage = "design.jpg";
                break;
            case "Android": basicImage = "Icon.jpg";
                break;
            default: basicImage = "java.jpg";
        }
        return basicImage;
    }

}
