package by.mikita.bialiayeu.server.service.impl;

import by.mikita.bialiayeu.server.dao.ClaimDAO;
import by.mikita.bialiayeu.server.model.Claim;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClaimServiceImpl {

    private ClaimDAO claimDAO;
    private ModelMapper modelMapper;

    @Autowired
    public ClaimServiceImpl(ClaimDAO claimDAO, ModelMapper modelMapper){
        this.claimDAO = claimDAO;
        this.modelMapper = modelMapper;
    }

    public void addUserInfo(Claim claim){
        claimDAO.save(claim);
    }

    public void deleteUserInfo(int idUserInfo){
        claimDAO.deleteById(idUserInfo);
    }

    public void updateUserInfoEmail(int idUserInfo, String newEmail){
        Optional<Claim> userInfoOptional = claimDAO.findById(idUserInfo);
        Claim claim = userInfoOptional.map(u -> modelMapper.map(u, Claim.class)).get();
        claim.setEmail(newEmail);
        claimDAO.save(claim);
    }

    public void updateUserInfoName(int idUserInfo, String newName){
        Optional<Claim> userInfoOptional = claimDAO.findById(idUserInfo);
        Claim claim = userInfoOptional.map(u -> modelMapper.map(u, Claim.class)).get();
        claim.setName(newName);
        claimDAO.save(claim);
    }


}
