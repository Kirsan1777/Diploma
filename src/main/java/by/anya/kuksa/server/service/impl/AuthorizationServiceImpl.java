package by.anya.kuksa.server.service.impl;

import by.anya.kuksa.server.dao.UserDAO;
import by.anya.kuksa.server.model.User;
import by.anya.kuksa.server.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    UserDAO userDAO;
    UserServiceImpl userService;

    @Autowired
    public AuthorizationServiceImpl(UserDAO userDAO, UserServiceImpl userService){
        this.userDAO = userDAO;
        this.userService = userService;
    }

    @Override
    public User authorization(String login, String password) {
        User user;
        user = userDAO.findUserByLoginAndPassword(login, password);
        return user;
    }

    @Override
    public void registration(String login, String password) {
        User user = new User();
        boolean check = userService.isExistUser(login);
        if(check){
            user.setLogin(login);
            user.setPassword(password);
            userDAO.save(user);
        }
    }
}
