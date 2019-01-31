package pl.mwisniewski.barber_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mwisniewski.barber_app.model.AnonymousOrder;

public interface AnonymousOrderRepository extends JpaRepository<AnonymousOrder, Long> {
}
