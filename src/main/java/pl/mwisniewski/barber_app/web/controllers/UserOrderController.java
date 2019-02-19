package pl.mwisniewski.barber_app.web.controllers;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.mwisniewski.barber_app.dto.OrderDateDTO;
import pl.mwisniewski.barber_app.dto.UserDto;
import pl.mwisniewski.barber_app.model.User;
import pl.mwisniewski.barber_app.model.UserOrder;
import pl.mwisniewski.barber_app.model.Service;
import pl.mwisniewski.barber_app.repositories.ServiceRepository;
import pl.mwisniewski.barber_app.repositories.UserOrderRepository;
import pl.mwisniewski.barber_app.repositories.UserRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserOrderController {
    private ServiceRepository serviceRepository;
    private UserOrderRepository userOrderRepository;
    private UserRepository userRepository;


    public UserOrderController(ServiceRepository serviceRepository, UserOrderRepository userOrderRepository, UserRepository userRepository) {
        this.serviceRepository = serviceRepository;
        this.userOrderRepository = userOrderRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("services")
    public List<Service> services() {
        return serviceRepository.findAll();
    }

    @GetMapping("/order/add")
    public String prepareUserOrderForm(Model model, Principal principal) {
//        List<OrderDateDTO> dateTimeList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).plusDays(1);
        LocalDateTime max = now.plusDays(14);
//        LocalDateTime start = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(), 8, 00);
//        for (int i = 0; i < 20; i++) {
//            OrderDateDTO orderDateDTO = new OrderDateDTO();
//            orderDateDTO.setDateOfOrderContract(start.plusMinutes(30 * i));
//            dateTimeList.add(orderDateDTO);
//        }
        UserOrder userOrder = new UserOrder();
        userOrder.setUser(userRepository.findByEmail(principal.getName()));
        model.addAttribute("now", now.format(formatter));
        model.addAttribute("max", max.format(formatter));
//        model.addAttribute("listOfVisitHours", dateTimeList);
        model.addAttribute("userOrder", userOrder);
        return "user-order-form";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(LocalDateTime.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"), false, 16));
    }

    @PostMapping("/order/add")
    public String saveUserOrder(@Valid UserOrder userOrder, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "user-order-form";
        }
        if (userOrder.getId() == null) {
            userOrder.setUser(userRepository.findByEmail(principal.getName()));
            userOrderRepository.save(userOrder);
        }
        return "redirect:/home";
    }
}
