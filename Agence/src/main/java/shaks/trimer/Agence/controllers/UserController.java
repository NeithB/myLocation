package shaks.trimer.Agence.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaks.trimer.Agence.modeles.User;
import shaks.trimer.Agence.services.UserServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    public final UserServiceImpl userService;
    @PostMapping("/inserer")
    public User inserUser(@RequestBody User user){
        return userService.save(user);
    }

}
