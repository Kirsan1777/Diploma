package by.mikita.bialiayeu.web.controller;


import by.mikita.bialiayeu.server.service.impl.EmailSendingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/mail")
@EnableAutoConfiguration
public class SenderEmail {

    private static final String MESSAGE_WITH_RESPONSE = "Congratulation you will accept on course";

    EmailSendingServiceImpl emailSendingService;
    AdminController adminController;

    @Autowired
    public SenderEmail(EmailSendingServiceImpl emailSendingService, AdminController adminController){
        this.emailSendingService = emailSendingService;
        this.adminController = adminController;
    }

    @GetMapping("/home")
    public ModelAndView viewMails(){
        ModelAndView model = new ModelAndView();
        model.setViewName("sendEmail");
        return model;
    }

    @GetMapping("/send-response-to-person")
    public ModelAndView sendMessage(@RequestParam("email") String email){
        ModelAndView model = new ModelAndView();
        emailSendingService.sendMessage(MESSAGE_WITH_RESPONSE, email);
        return adminController.claimPage();
    }
}
