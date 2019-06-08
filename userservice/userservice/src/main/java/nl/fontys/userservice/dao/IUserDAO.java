package nl.fontys.userservice.dao;


import nl.fontys.userservice.domain.User;

public interface IUserDAO {
    void newUser(User user);
    User getUser(String username);
}
