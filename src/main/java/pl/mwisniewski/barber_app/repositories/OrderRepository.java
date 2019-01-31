package pl.mwisniewski.barber_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mwisniewski.barber_app.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
