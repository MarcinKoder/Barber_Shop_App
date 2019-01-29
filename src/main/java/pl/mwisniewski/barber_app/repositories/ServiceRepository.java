package pl.mwisniewski.barber_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mwisniewski.barber_app.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
