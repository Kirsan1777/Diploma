package by.mikita.bialiayeu.web.controller;

import by.mikita.bialiayeu.server.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
public class TestController {

    private CourseServiceImpl bookService;

    @Autowired
    public TestController(CourseServiceImpl bookService){
        this.bookService = bookService;
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

}
