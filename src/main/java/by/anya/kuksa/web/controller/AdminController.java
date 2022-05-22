package by.anya.kuksa.web.controller;

import by.anya.kuksa.server.model.*;
import by.anya.kuksa.server.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/admin")
@EnableAutoConfiguration
public class AdminController {

    @Autowired
    private AuthorizationServiceImpl authorizationService;
    private ClaimServiceImpl claimService;
    private TeacherServiceImpl teacherService;
    private CourseServiceImpl courseService;
    private BlogServiceImpl blogService;
    private MainUserPageController mainUserPageController;

    @Autowired
    public AdminController(AuthorizationServiceImpl authorizationService, ClaimServiceImpl claimService,
                           TeacherServiceImpl teacherService, CourseServiceImpl courseService,
                           BlogServiceImpl blogService, MainUserPageController mainUserPageController){
        this.authorizationService = authorizationService;
        this.claimService = claimService;
        this.teacherService =teacherService;
        this.courseService = courseService;
        this.blogService = blogService;
        this.mainUserPageController = mainUserPageController;
    }

    @GetMapping("/")
    public ModelAndView mainPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @GetMapping("/login")
    public ModelAndView index(@RequestParam("login") String login, @RequestParam("password") String password){
        ModelAndView model = new ModelAndView();
        User user = authorizationService.authorization(login, password);
        if(user != null){
            return coursePage();
        }else {
            model.addObject("message", "Mistake");
            model.setViewName("login");
        }
        return model;
    }


    @GetMapping("/course")
    public ModelAndView coursePage(){
        ModelAndView model = new ModelAndView();
        List<Course> courses = courseService.findAllCourses();
        List<Teacher> teachers = teacherService.findAllTeacher();
        model.setViewName("adminCourse");
        model.addObject("courses", courses);
        model.addObject("teachers", teachers);
        return model;
    }

    @PostMapping("/claim/addNew")
    public ModelAndView addNewClaimCommand(@RequestParam("name") String name,
                                           @RequestParam("email") String email,
                                            @RequestParam("phone") String phone,
                                           @RequestParam("id") int id){
        Claim claim = new Claim();
        claim.setName(name);
        claim.setEmail(email);
        claim.setPhoneNumber(phone);
        claim.setIdCourse(id);
        claimService.addUserInfo(claim);
        return mainUserPageController.coursesByIdPage(Integer.toString(id));
    }

    @PostMapping("/course/addNew")
    public ModelAndView addNewCourseCommand(@RequestParam("name_course") String nameCourse,@RequestParam("description") String description,
                                            @RequestParam("type") String typeOfCourse,@RequestParam("cost") double cost,
                                            @RequestParam("start_time") String startTime,@RequestParam("schedule") String schedule,
                                            @RequestParam("continuance") String continuance,@RequestParam("text") String text,
                                            @RequestParam("teacher") int teacher){
        Course course = new Course();
        course.setNameCourse(nameCourse);
        course.setDescription(description);
        course.setTypeOfCourse(typeOfCourse);
        course.setCost(cost);
        course.setStartTime(startTime);
        course.setSchedule(schedule);
        course.setContinuance(continuance);
        course.setText(text);
        course.setTeacher(teacher);
        courseService.addNewCourse(course);
        return coursePage();
    }

    @PostMapping("/course/delete/{idCourse}")
    public ModelAndView courseDeleteCommand(@PathVariable int idCourse){
        courseService.deleteCourseById(idCourse);
        return coursePage();
    }


    @GetMapping("/blog")
    public ModelAndView blogPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("blogs", blogService.findAllBlogs());
        model.setViewName("adminBlog");
        return model;
    }

    @PostMapping("/blog/addNew")
    public ModelAndView addBlogCommand(@RequestParam("name_blog") String nameBlog, @RequestParam("type") String description,
                                          @RequestParam("text") String text, @RequestParam("picture") String picture){
        Blog blog = new Blog();
        blog.setName(nameBlog);
        blog.setDescription(description);
        blog.setPicture(picture);
        if(blog.getPicture().equals("")){
            blog.setPicture("19002.jpg");
        }
        blog.setText(text);
        blog.setDateAdd(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
        blogService.addBlog(blog);
        return blogPage();
    }

    @PostMapping("/blog/delete/{idBlog}")
    public ModelAndView blogDeleteUserCommand(@PathVariable int idBlog){
        blogService.deleteBlog(idBlog);
        return blogPage();
    }

    @GetMapping("/claim")
    public ModelAndView claimPage(){
        ModelAndView model = new ModelAndView();
        List<Claim> claims = claimService.findAllClaims();
        List<Course> courses = courseService.findAllCourses();
        model.addObject("claims", claims);
        model.addObject("courses", courses);
        model.setViewName("adminClaim");
        return model;
    }

    @PostMapping("/claim/delete/{idUser}")
    public ModelAndView claimDeleteUserCommand(@PathVariable int idUser){
        claimService.deleteUserInfo(idUser);
        return claimPage();
    }

    @GetMapping("/teacher")
    public ModelAndView teacherPage(){
        ModelAndView model = new ModelAndView();
        List<Teacher> teachers = teacherService.findAllTeacher();
        model.addObject("teachers", teachers);
        model.setViewName("adminTeacher");
        return model;
    }

    @PostMapping("/teacher/addNew")
    public ModelAndView newTeacherCommand(@RequestParam("first_name") String firstName, @RequestParam("second_name") String secondName,
                                          @RequestParam("skill") String skill, @RequestParam("picture") String namePicture){
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setSecondName(secondName);
        teacher.setSkill(skill);
        teacher.setPhotoReference(namePicture);
        teacherService.addTeacher(teacher);
        return teacherPage();
    }

    @PostMapping("/teacher/delete/{idTeacher}")
    public ModelAndView teacherDeleteCommand(@PathVariable int idTeacher){
        teacherService.deleteTeacher(idTeacher);
        return teacherPage();
    }

}
