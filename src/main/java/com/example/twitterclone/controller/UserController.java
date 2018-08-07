package com.example.twitterclone.controller;
import java.util.List;

import com.example.twitterclone.domain.User;
import com.example.twitterclone.repository.UserRepository;
import com.example.twitterclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String index(Model model) {
        List<User> list=userRepository.findAll();
        model.addAttribute("list", list);
        return "users";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String create(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "/register";
        userService.save(user);
        return "redirect:/hello";
    }
}
