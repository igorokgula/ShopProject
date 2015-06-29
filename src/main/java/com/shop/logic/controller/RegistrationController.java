package com.shop.logic.controller;

import com.shop.logic.exception.UserAlreadyExistsException;
import com.shop.logic.service.UserService;
import com.shop.presentation.form.RegistrationForm;
import com.shop.storage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Igor on 27.06.2015.
 */
@Controller
@RequestMapping(value = "registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "checkIfUsernameExists", method = RequestMethod.GET)
    @ResponseBody
    public boolean usernameExists(@RequestParam("username") String username) {
        User user = userService.getUserByUsername(username);
        return (user != null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String goToRegistrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
                               BindingResult result, Model model) {
        if (!registrationForm.passwordsMatch()) {
            model.addAttribute("passwordsDontMatch", true);
            return "registration";
        }
        if (result.hasErrors()) {
            return "registration";
        }
        try {
            userService.registerUser(registrationForm);
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("usernameExists",  true);
            return "registration";
        }
        model.addAttribute("message", "registration_was_successfull");
        return "login";
    }

}
