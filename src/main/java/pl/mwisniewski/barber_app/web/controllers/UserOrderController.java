package pl.mwisniewski.barber_app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import java.time.LocalDateTime;
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
        List<OrderDateDTO> dateTimeList = new ArrayList<>();
        LocalDateTime start = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(), 8, 00);
        for (int i = 0; i < 20; i++) {
            OrderDateDTO orderDateDTO = new OrderDateDTO();
            orderDateDTO.setDateOfOrderContract(start.plusMinutes(30 * i));
            dateTimeList.add(orderDateDTO);
        }
        UserOrder userOrder = new UserOrder();
        userOrder.setUser(userRepository.findByEmail(principal.getName()));
        model.addAttribute("listOfVisitHours", dateTimeList);
        model.addAttribute("userOrder", userOrder);
        return "user-order-form";
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
