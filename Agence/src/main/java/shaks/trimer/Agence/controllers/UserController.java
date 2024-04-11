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
    public User inserUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/listUser")
    public List<User> listUser(@RequestBody User user){
        return userService.findAll();
    }

    @PutMapping("/update/{id}")
    public User upadteUser(@PathVariable Integer id, @RequestBody User user){
        return userService.update(user,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
}
