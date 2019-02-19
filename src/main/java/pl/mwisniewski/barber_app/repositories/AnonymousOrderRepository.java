package pl.mwisniewski.barber_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.mwisniewski.barber_app.model.AnonymousOrder;

import java.util.List;

public interface AnonymousOrderRepository extends JpaRepository<AnonymousOrder, Long> {
}
