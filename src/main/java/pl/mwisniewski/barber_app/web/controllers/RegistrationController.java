package pl.mwisniewski.barber_app.web.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mwisniewski.barber_app.core.RegistrationService;
import pl.mwisniewski.barber_app.dto.RegistrationFormDTO;
import pl.mwisniewski.barber_app.dto.UserDto;
import pl.mwisniewski.barber_app.model.User;
import pl.mwisniewski.barber_app.repositories.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping
public class RegistrationController {


    private RegistrationService registrationService;


    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "user-registration-form";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegistrationFormDTO registrationFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "user-registration-form";
        }
        boolean success = registrationService.register(registrationFormDTO);
        if (success) {
            return "redirect:/login";
        } else {
            result.rejectValue("email", null, "Email jest już w systemie");
            return "user-registration-form";
        }
    }

    @GetMapping("/login")
    public String prepareLoginForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user-login-form";
    }
}
