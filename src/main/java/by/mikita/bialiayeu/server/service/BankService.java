package by.mikita.bialiayeu.server.service;

public interface BankService {

    double findUserBalance(int idUser);

    void updateUserBalance(int idUser, double value);

}
