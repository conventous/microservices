package nl.fontys.userservice.dao;

import nl.fontys.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUsername(String username); //https://www.concretepage.com/spring-5/spring-data-crudrepository-example#Methods
}
