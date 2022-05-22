package by.anya.kuksa.web.controller;

import by.anya.kuksa.server.service.impl.CourseServiceImpl;
import by.anya.kuksa.server.service.impl.UserServiceImpl;
import by.anya.kuksa.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
public class TestController {

    private CourseServiceImpl bookService;
    private UserServiceImpl userService;

    @Autowired
    public TestController(CourseServiceImpl bookService, UserServiceImpl userService){
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.addObject("test", bookService.findCourseById(1));
        model.setViewName("home");
        return model;
    }

    @GetMapping("/post")
    public ModelAndView postRequest(@RequestParam("idCourse") int idCourse){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home2");
        modelAndView.addObject("test", bookService.findCourseById(idCourse));
        return modelAndView;
    }

    @GetMapping("/posted")
    public ModelAndView postRequested(@RequestParam("idCourse") int idCourse){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home2");
        modelAndView.addObject("test", bookService.findCourseById(idCourse));
        return modelAndView;
    }

    @PostMapping("/addUser")
    public ModelAndView addUser(@RequestParam("id") int idUser, @RequestParam("login") String login){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setIdUser(idUser);
        user.setLogin(login);
        user.setPassword(login);
        userService.addUser(user);
        modelAndView.setViewName("test");
        return modelAndView;
    }

}
