package by.mikita.bialiayeu.server.service.impl;


import by.mikita.bialiayeu.server.dao.CourseDAO;
import by.mikita.bialiayeu.server.model.Course;
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

    public List<Course> findCourseByName(String nameCourse){
        List<Course> courses = courseDAO.findAllByNameCourse(nameCourse);
        return courses;
    }

    public Course findCourseById(int idCourse){
        Optional<Course> courseOptional = courseDAO.findById(idCourse);
        Course course = courseOptional.map( c -> modelMapper.map(c, Course.class)).get();
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

    private String setBasicImage(String type){
        String basicImage = "";
        switch (type){
            case "Java": basicImage = "19002.jpg";
                break;
            case "JavaScript": basicImage = "somber-cat-.jpg";
                break;
            case "QA": basicImage = "uOnpvhQktPw.jpg";
                break;
            case "Design": basicImage = "ShayaArcana.jpg";
                break;
            case "Android": basicImage = "842165.jpg";
                break;
            default: basicImage = "19002.jpg";
        }
        return basicImage;
    }

}
