package by.mikita.bialiayeu.server.service;


import by.mikita.bialiayeu.server.model.User;
import by.mikita.bialiayeu.server.model.Claim;
import org.springframework.data.domain.Page;

public interface UserService {

    void addUser(User user);

    void deleteUser(int idUser);

    Page<Claim> getAllUserInfo();

    void updateUserInfo(User user);

    User findUserById(int idUser);

    Claim findUserInfoById(int idUser);

    User findUserByLogin(String login);

    Claim findAllUserByName(String username);



}
