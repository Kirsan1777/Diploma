package by.mikita.bialiayeu.server.service.impl;


import by.mikita.bialiayeu.server.dao.UserDAO;
import by.mikita.bialiayeu.server.dao.UserInfoDAO;
import by.mikita.bialiayeu.server.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl /*implements UserService*/ {

    private static final String DEFAULT_USER_STATUS = "ACTIVE";
    private static final String DEFAULT_USER_ROLE = "USER";

    @Autowired
    UserDAO userDAO;
    UserInfoDAO userInfoDAO;
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserInfoDAO userInfoDAO, ModelMapper modelMapper){
        this.userDAO = userDAO;
        this.modelMapper = modelMapper;
        this.userInfoDAO = userInfoDAO;
    }

    public boolean isExistUser(String login){
        boolean isExist = false;
        isExist = userDAO.findUserByLogin(login) == null;
        return isExist;
    }

    public void addUser(User user){
        user.setRole(DEFAULT_USER_ROLE);
        user.setStatus(DEFAULT_USER_STATUS);
        userDAO.save(user);
    }

    public void deleteUser(int idUser){
        userDAO.deleteById(idUser);
    }

    public List<User> findAllUsers(){
        return userDAO.findAll();
    }

    public User findUserById(int idUser){
        Optional<User> user = userDAO.findById(idUser);
        return user.map(u -> modelMapper.map(u, User.class)).get();
    }

    public  void updateUserRole(int idUser, String newRole){
        User user = findUserById(idUser);
        user.setRole(newRole);
        userDAO.save(user);
    }

    public  void updateUserStatus(int idUser, String newStatus){
        User user = findUserById(idUser);
        user.setStatus(newStatus);
        userDAO.save(user);
    }
}
