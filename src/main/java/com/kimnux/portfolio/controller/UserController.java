package com.kimnux.portfolio.controller;

import com.kimnux.portfolio.model.User;
import com.kimnux.portfolio.repository.UserRepository;
import com.kimnux.portfolio.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("user", new User());
        return "user/join";
    }

    @PostMapping("/joinOk")
    public String joinOk(User user, BindingResult bindingResult) {
        log.info("user =====> {}", user);

        userValidator.validate(user, bindingResult);
        log.info("bindingResult.hasErrors() ===> {}", bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            return "user/join";
        }

        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

}
