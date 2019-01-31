package pl.mwisniewski.barber_app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mwisniewski.barber_app.dto.OrderDateDTO;
import pl.mwisniewski.barber_app.dto.RegistrationFormDTO;
import pl.mwisniewski.barber_app.model.AnonymousOrder;
import pl.mwisniewski.barber_app.model.Order;
import pl.mwisniewski.barber_app.model.Service;
import pl.mwisniewski.barber_app.repositories.AnonymousOrderRepository;
import pl.mwisniewski.barber_app.repositories.OrderRepository;
import pl.mwisniewski.barber_app.repositories.ServiceRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class AnonymousOrderController {

    private ServiceRepository serviceRepository;
    private AnonymousOrderRepository anonymousOrderRepository;
    private OrderRepository orderRepository;

    public AnonymousOrderController(ServiceRepository serviceRepository, AnonymousOrderRepository anonymousOrderRepository, OrderRepository orderRepository) {
        this.serviceRepository = serviceRepository;
        this.anonymousOrderRepository = anonymousOrderRepository;
        this.orderRepository = orderRepository;
    }


    @ModelAttribute("services")
    public List<Service> services(){ return serviceRepository.findAll();}

    @GetMapping("/add")
    public String prepareAnonymousOrderForm(Model model) {
        List<OrderDateDTO> dateTimeList = new ArrayList<>();
        LocalDateTime start = LocalDateTime.of(LocalDateTime.now().getYear(),LocalDateTime.now().getMonth(),LocalDateTime.now().getDayOfMonth(),8,00);
        for (int i = 0; i < 20; i++) {
         OrderDateDTO orderDateDTO = new OrderDateDTO();
         orderDateDTO.setDateOfOrderContract(start.plusMinutes(30*i));
         dateTimeList.add(orderDateDTO);
        }
        model.addAttribute("listOfVisitHours", dateTimeList);
        model.addAttribute("anonOrder", new AnonymousOrder());
        return "anonymous-order-form";
    }

    @PostMapping("/add")
    public String saveAnonymousOrder(@Valid AnonymousOrder anonymousOrder, BindingResult result) {
        if (result.hasErrors()) {
            return "anonymous-order-form";
        }
        if (anonymousOrder.getId() == null) {
            anonymousOrderRepository.save(anonymousOrder);
        }
        return "redirect:/home";
    }
}
