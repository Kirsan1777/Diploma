package by.mikita.bialiayeu.web.controller;

import by.mikita.bialiayeu.server.model.User;
import by.mikita.bialiayeu.server.service.impl.AuthorizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
@EnableAutoConfiguration
public class AdminController {

    @Autowired
    private AuthorizationServiceImpl authorizationService;


    public AdminController(AuthorizationServiceImpl authorizationService){
        this.authorizationService = authorizationService;
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
            model.setViewName("adminCourse");
        }else {
            model.addObject("message", "Mistake");
            model.setViewName("login");
        }

        return model;
    }


    @GetMapping("/course")
    public ModelAndView coursePage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("adminCourse");
        return model;
    }


    @GetMapping("/blog")
    public ModelAndView blogPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("adminBlog");
        return model;
    }

    @GetMapping("/claim")
    public ModelAndView claimPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("adminClaim");
        return model;
    }

    @GetMapping("/teacher")
    public ModelAndView teacherPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("adminTeacher");
        return model;
    }

}
