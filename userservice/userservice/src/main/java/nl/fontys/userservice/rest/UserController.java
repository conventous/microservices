package nl.fontys.userservice.rest;

import nl.fontys.userservice.domain.User;
import nl.fontys.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/") //zuul redirect hierna toe
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/newuser")
    public void newUser(@RequestBody User user){
        this.userService.newUser(user);
    }

    @GetMapping(value = "/getuser")
    public User getUser(@RequestParam(value="username") String username) {
        return this.userService.getUser(username);
    }
}
