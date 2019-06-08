package nl.fontys.userservice.service;

import nl.fontys.userservice.dao.UserRepoCRUD;
import nl.fontys.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    // private IUserDAO UserDAO;

    //UserRepoCRUD repo = context.getBean(UserRepoCRUD.class);

    @Autowired
    private UserRepoCRUD userDAO;

    public User getUser(String username){
        return this.userDAO.findByUsername(username);
    }

    public void newUser(User user){
        this.userDAO.save(user);
    }
}
