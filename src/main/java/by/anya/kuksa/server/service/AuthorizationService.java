package by.anya.kuksa.server.service;

import by.anya.kuksa.server.model.User;

public interface AuthorizationService {

    User authorization(String login, String password);

    /**
     * registers a new user
     *
     * @param login    the user login
     * @param password the user password
     */
    void registration(String login, String password);

}
