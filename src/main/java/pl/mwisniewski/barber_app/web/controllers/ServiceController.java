package pl.mwisniewski.barber_app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mwisniewski.barber_app.model.Service;
import pl.mwisniewski.barber_app.repositories.ServiceRepository;

import javax.validation.Valid;

@Controller
@RequestMapping
public class ServiceController {
    private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping
    public String prepareListOfServices(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "all-services";
    }

    @GetMapping("/allservices")
    public String getListOfServices(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "all-services";
    }

    @GetMapping("/admin/services/add")
    public String prepareAddServiceForm(Model model) {
        model.addAttribute("service", new Service());
        return "service-add-edit-form";
    }

    @PostMapping("/admin/services/add")
    public String saveServicer(@Valid Service service, BindingResult result) {
        if (result.hasErrors()) {
            return "service-add-edit-form";
        }
        if (service.getId() == null) {
            serviceRepository.save(service);
        }
        return "redirect:/allservices";
    }

    @GetMapping("/admin/services/update/{id:[1-9][0-9]*}")
    public String prepareServiceToEdit(@PathVariable Long id, Model model) {
        Service service = serviceRepository.findById(id).get();
        if (service.getId() == null) {
            return "Nie znaleziono usługi";
        }
        model.addAttribute("service", service);
        return "service-add-edit-form";
    }

    @PostMapping("/admin/services/update/{id:[1-9][0-9]*}")
    public String editService(@Valid Service service, BindingResult result) {
        if (result.hasErrors()) {
            return "service-add-edit-form";
        }
        if (service.getId() != null) {
            serviceRepository.save(service);
        }
        return "redirect:/allservices";
    }

    @GetMapping("/admin/services/delete/{id:[1-9][0-9]*}")
    public String deleteService(@PathVariable Long id) {
        Service service= serviceRepository.findById(id).get();
        if (service.getId() != null){
            serviceRepository.delete(service);
        }
        return "redirect:/allservices";
    }
}
