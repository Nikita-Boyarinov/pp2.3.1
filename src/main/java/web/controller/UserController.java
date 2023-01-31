package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.services.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAll());
        return "users";
    }


    @GetMapping("/newUser")
    public String createNewUser(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "new";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String updateUser(ModelMap modelMap, @PathVariable("id") long id) {
        modelMap.addAttribute("user", userService.getUser(id));
        return "update";
    }
    @PatchMapping("/{id}")
    public String saveUpdateUser(@ModelAttribute("user") User user, @PathVariable("id") long id){
        user.setId(id);
        userService.update(user);
    return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id){
        userService.delete(id);
        return "redirect:/";
    }
}
