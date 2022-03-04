package by.mikita.bialiayeu.server.service.impl;


import by.mikita.bialiayeu.server.dao.UserDAO;
import by.mikita.bialiayeu.server.dao.UserInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl /*implements UserService*/ {

    @Autowired
    UserDAO userDAO;
    UserInfoDAO userInfoDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserInfoDAO userInfoDAO){
        this.userDAO = userDAO;
        this.userInfoDAO = userInfoDAO;
    }

    public boolean isExistUser(String login){
        boolean isExist = false;
        isExist = userDAO.findUserByLogin(login) == null;
        return isExist;
    }



}
