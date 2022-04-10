package by.mikita.bialiayeu.web.controller;


import by.mikita.bialiayeu.server.service.impl.EmailSendingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/mail")
@EnableAutoConfiguration
public class SenderEmail {

    EmailSendingServiceImpl emailSendingService;

    @Autowired
    public SenderEmail(EmailSendingServiceImpl emailSendingService){
        this.emailSendingService = emailSendingService;
    }

    @GetMapping("/home")
    public ModelAndView viewMails(){
        ModelAndView model = new ModelAndView();
        model.setViewName("sendEmail");
        return model;
    }

    @GetMapping("/send-basic")
    public ModelAndView sendMessage(){
        ModelAndView model = new ModelAndView();
        emailSendingService.sendMessage();
        model.addObject("message", "message was send");
        model.setViewName("sendEmail");
        return model;
    }
}
