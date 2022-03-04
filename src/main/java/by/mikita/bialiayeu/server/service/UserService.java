package by.mikita.bialiayeu.server.service;


import by.mikita.bialiayeu.server.model.User;
import by.mikita.bialiayeu.server.model.UserInfo;
import org.springframework.data.domain.Page;

public interface UserService {

    void addUser(User user);

    void deleteUser(int idUser);

    Page<UserInfo> getAllUserInfo();

    void updateUserInfo(User user);

    User findUserById(int idUser);

    UserInfo findUserInfoById(int idUser);

    User findUserByLogin(String login);

    UserInfo findAllUserByName(String username);



}
