package by.mikita.bialiayeu.web.controller;

import by.mikita.bialiayeu.server.model.Blog;
import by.mikita.bialiayeu.server.model.Course;
import by.mikita.bialiayeu.server.model.Teacher;
import by.mikita.bialiayeu.server.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/main")
@EnableAutoConfiguration
public class MainUserPageController {

    @Autowired
    private AuthorizationServiceImpl authorizationService;
    private ClaimServiceImpl claimService;
    private TeacherServiceImpl teacherService;
    private CourseServiceImpl courseService;
    private BlogServiceImpl blogService;

    @Autowired
    public MainUserPageController(AuthorizationServiceImpl authorizationService, ClaimServiceImpl claimService,
                           TeacherServiceImpl teacherService, CourseServiceImpl courseService,
                           BlogServiceImpl blogService){
        this.authorizationService = authorizationService;
        this.claimService = claimService;
        this.teacherService =teacherService;
        this.courseService = courseService;
        this.blogService = blogService;
    }

    @GetMapping("/")
    public ModelAndView mainPage(){
        ModelAndView model = new ModelAndView();
        List<Teacher> teachers = teacherService.findAllTeacher().subList(0, 4);
        List<Course> courses = courseService.findAllCourses().subList(0, 3);
        List<Blog> blogs = blogService.findAllBlogs().subList(0, 3);
        model.addObject("teachers", teachers);
        model.addObject("courses", courses);
        model.addObject("blogs", blogs);
        model.setViewName("mainPage");
        return model;
    }

    @GetMapping("/courses")
    public ModelAndView coursesPage(){
        ModelAndView model = new ModelAndView();
        List<Course> coursesJava = courseService.findCourseByType("Java");
        List<Course> coursesJS = courseService.findCourseByType("Java Script");
        List<Course> coursesQA = courseService.findCourseByType("QA");
        List<Course> coursesDesign = courseService.findCourseByType("Design");
        List<Course> coursesAndroid = courseService.findCourseByType("Android");
        model.addObject("coursesJava", coursesJava);
        model.addObject("coursesJS", coursesJS);
        model.addObject("coursesQA", coursesQA);
        model.addObject("coursesDesign", coursesDesign);
        model.addObject("coursesAndroid", coursesAndroid);
        model.setViewName("courseMain");
        return model;
    }

    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("mainTest");
        return model;
    }

    @GetMapping("/teachers")
    public ModelAndView teachersPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("java", teacherService.findTeachersBySkill("Java"));
        model.addObject("android", teacherService.findTeachersBySkill("Android"));
        model.addObject("javaScript", teacherService.findTeachersBySkill("JavaScript"));
        model.addObject("qa", teacherService.findTeachersBySkill("QA"));
        model.addObject("design", teacherService.findTeachersBySkill("Design"));
        model.setViewName("mainTeacher");
        return model;
    }

    @GetMapping("/contacts")
    public ModelAndView contactPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("contact");
        return model;
    }

    @GetMapping("/blogs")
    public ModelAndView blogsPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("mainBlogs");
        return model;
    }

}
