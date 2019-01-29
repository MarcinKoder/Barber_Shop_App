package pl.mwisniewski.barber_app.web.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mwisniewski.barber_app.dto.UserDto;
import pl.mwisniewski.barber_app.model.User;
import pl.mwisniewski.barber_app.repositories.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private UserDto userDto;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, UserDto userDto) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDto = userDto;
    }

    @GetMapping("/register")
    public String prepareRegistrationForm(Model model){
        model.addAttribute("newUser", new User());
        return "user-registration-form";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("newUser") @Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "user-registration-form";
        }
        User userByEmail = userRepository.findByEmail(user.getEmail());
        if (userByEmail != null){
            result.rejectValue("email",null,"Email jest już w systemie");
            return "user-registration-for";
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "redirect:/home";
    }

        @GetMapping("/login")
        public String prepareLoginForm(Model model) {
            model.addAttribute("userDto", new UserDto());
            return "user-login-form";
        }

        @PostMapping("/login")
        public String loginUser(@ModelAttribute UserDto userDto,
                                BindingResult result, HttpSession session) {
            User userByEmail = userRepository.findByEmail(userDto.getEmail());
            if (userByEmail == null) {
                result.rejectValue("password", null, "Błędny email lub hasło");
                return "user-login-form";
            }
            if (!passwordEncoder.matches(userDto.getPassword(),
                    userByEmail.getPassword())) {
                result.rejectValue("password", null, "Błędny email lub hasło");
                return "user-login-form";
            }
            session.setAttribute("user", userByEmail);
            session.setAttribute("name", userByEmail.getName());
            return "redirect:/";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate();
            return "redirect:/";
        }
}
