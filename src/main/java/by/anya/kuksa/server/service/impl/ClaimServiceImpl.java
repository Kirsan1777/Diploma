package by.anya.kuksa.server.service.impl;

import by.anya.kuksa.server.dao.ClaimDAO;
import by.anya.kuksa.server.model.Claim;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        claim.setDateRegistration(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
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

    public List<Claim> findAllClaims(){
        return claimDAO.findAll();
    }


}
