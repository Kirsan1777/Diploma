package by.anya.kuksa.server.service;

public interface BankService {

    double findUserBalance(int idUser);

    void updateUserBalance(int idUser, double value);

}
