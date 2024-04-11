package shaks.trimer.Agence.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shaks.trimer.Agence.modeles.User;
import shaks.trimer.Agence.services.UserServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    public final UserServiceImpl userService;
    @PostMapping("/inserer")
    public User inserUser( User user){
        return null;
    }

    @GetMapping("/listUser")
    public List<User> listUser(User user){
        return null;
    }

    @PutMapping("/update/{id}")
    public User upadteUser(@PathVariable Integer id, @RequestBody User user){
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
}
