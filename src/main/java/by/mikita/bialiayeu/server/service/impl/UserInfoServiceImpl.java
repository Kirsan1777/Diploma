package by.mikita.bialiayeu.server.service.impl;

import by.mikita.bialiayeu.server.dao.UserInfoDAO;
import by.mikita.bialiayeu.server.model.UserInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoServiceImpl {

    private UserInfoDAO userInfoDAO;
    private ModelMapper modelMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoDAO userInfoDAO, ModelMapper modelMapper){
        this.userInfoDAO = userInfoDAO;
        this.modelMapper = modelMapper;
    }

    public void addUserInfo(UserInfo userInfo){
        userInfoDAO.save(userInfo);
    }

    public void deleteUserInfo(int idUserInfo){
        userInfoDAO.deleteById(idUserInfo);
    }

    public void updateUserInfoEmail(int idUserInfo, String newEmail){
        Optional<UserInfo> userInfoOptional = userInfoDAO.findById(idUserInfo);
        UserInfo userInfo = userInfoOptional.map( u -> modelMapper.map(u, UserInfo.class)).get();
        userInfo.setEmail(newEmail);
        userInfoDAO.save(userInfo);
    }

    public void updateUserInfoName(int idUserInfo, String newName){
        Optional<UserInfo> userInfoOptional = userInfoDAO.findById(idUserInfo);
        UserInfo userInfo = userInfoOptional.map( u -> modelMapper.map(u, UserInfo.class)).get();
        userInfo.setName(newName);
        userInfoDAO.save(userInfo);
    }


}
