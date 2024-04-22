package shaks.trimer.Agence.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shaks.trimer.Agence.modeles.User;
import shaks.trimer.Agence.services.UserServiceImpl;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/user/")
public class UserController {

    public final UserServiceImpl userService;

    @PostMapping("/inserer")
    public User inserUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/")
    public List<User> listUser() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.findById(id);
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
