package by.anya.kuksa.web.controller;

import by.anya.kuksa.server.model.Blog;
import by.anya.kuksa.server.model.Course;
import by.anya.kuksa.server.model.Teacher;
import by.anya.kuksa.server.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/courses/{id}")
    public ModelAndView coursesByIdPage(@PathVariable("id") String idString){
        ModelAndView model = new ModelAndView();
        int id = Integer.parseInt(idString);
        Course course = courseService.findCourseById(id);
        Teacher teacher = teacherService.findTeacherById(course.getTeacher());
        model.addObject("course", course);
        model.addObject("teacher", teacher);
        model.setViewName("courseInfo");
        return model;
    }

    @GetMapping("/blog/{id}")
    public ModelAndView blogByIdPage(@PathVariable("id") int id){
        ModelAndView model = new ModelAndView();
        Blog blog = blogService.findBlogById(id);
        model.addObject("blog", blog);
        model.setViewName("blogInfo");
        return model;
    }

    @GetMapping("/course/find")
    public ModelAndView courseSearchCommand(@RequestParam("name") String name){
        ModelAndView model = new ModelAndView();
        List<Course> courses =  courseService.findAllCoursesByName(name);
        if(courses.size() < 1){
            model.addObject("message", "nothing find");
        }
        model.addObject("coursesFind", courses);
        model.setViewName("courseMain");
        return model;
    }

    @GetMapping("/course/filter")
    public ModelAndView courseSearchFilterCommand(@RequestParam("type") String type,
                                                  @RequestParam("continuance") String continuance,
                                                  @RequestParam("price") double price){
        ModelAndView model = new ModelAndView();
        List<Course> courses =  courseService.findAllByFilter(type, continuance, price);
        if(courses.size() < 1){
            model.addObject("message", "nothing find");
        }
        model.addObject("coursesFind", courses);
        model.setViewName("courseMain");
        return model;
    }

    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("mainTest");
        return model;
    }

    @GetMapping("/test/result")
    public ModelAndView testResultPage(@RequestParam("radio") int one,
                                       @RequestParam("radio2") int two,
                                       @RequestParam("radio3") int three,
                                       @RequestParam("radio4") int four,
                                       @RequestParam("radio5") int five){
        ModelAndView model = new ModelAndView();
        int result = (one + two + three + four + five) / 5;
        switch (result) {
            case 1: {
                model.addObject("picture", 1);
                break;
            }
            case 2: {
                model.addObject("picture", 2);
                break;
            }
            case 3: {
                model.addObject("picture", 3);
                break;
            }
            case 4: {
                model.addObject("picture", 4);
            }
            case 5: {
                model.addObject("picture", 4);
                break;
            }
            default:
            {

            }
        }
        model.setViewName("testResult");
        return model;
    }

    @GetMapping("/teachers")
    public ModelAndView teachersPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("java", teacherService.findTeachersBySkill("Java Developer"));
        model.addObject("android", teacherService.findTeachersBySkill("Android"));
        model.addObject("javaScript", teacherService.findTeachersBySkill("JavaScript Developer"));
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
        model.addObject("blogs", blogService.findAllBlogsByDesc("Java"));
        model.addObject("pictureName", "java (1).jpg");
        model.setViewName("mainBlogs");
        return model;
    }

    @GetMapping("/blogs_android")
    public ModelAndView blogsAndroidPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("blogs", blogService.findAllBlogsByDesc("Android"));
        model.addObject("pictureName", "and.jpg");
        model.setViewName("mainBlogs");
        return model;
    }
    @GetMapping("/blogs_js")
    public ModelAndView blogsJSPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("blogs", blogService.findAllBlogsByDesc("JavaScript"));
        model.addObject("pictureName", "js (1).jpg");
        model.setViewName("mainBlogs");
        return model;
    }
    @GetMapping("/blogs_qa")
    public ModelAndView blogsQAPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("blogs", blogService.findAllBlogsByDesc("QA"));
        model.addObject("pictureName", "QA (1).jpg");
        model.setViewName("mainBlogs");
        return model;
    }
    @GetMapping("/blogs_ux_ui")
    public ModelAndView blogsUXPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("blogs", blogService.findAllBlogsByDesc("UX/UI"));
        model.addObject("pictureName", "ux.jpg");
        model.setViewName("mainBlogs");
        return model;
    }

}
