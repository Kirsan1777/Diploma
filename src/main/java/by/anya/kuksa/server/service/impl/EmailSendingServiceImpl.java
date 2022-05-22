package by.anya.kuksa.server.service.impl;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@Component
public class EmailSendingServiceImpl {//WTF 0_0 ????

    private final static String USERNAME = "forwftask@gmail.com";
    private final static String PASSWORD = "wftaskwf";

    public void sendMessage(String messageToUser, String email) {
        try{
            Properties prop = new Properties();
            /*prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");*/

            prop.put("mail.transport.protocol", "smtps");
            prop.put("mail.smtps.host", "smtp.gmail.com");
            prop.put("mail.smtps.auth", "true");
            prop.put("mail.smtp.sendpartial", "true");
            prop.put("mail.smtps.starttls.enable", "true");
            prop.put("mail.smtps.user", USERNAME);

            Session session = Session.getDefaultInstance(prop);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("forWFTask@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(email));//this is email person
            message.setSubject("Courses information");

            String msg = "This is my first email using JavaMailer";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(messageToUser, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport transport = session.getTransport();
            transport.connect("smtp.gmail.com", 465, USERNAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
        }catch (MessagingException ex){
            System.out.println("We have problem with sending email" + ex);
        }

    }


}
