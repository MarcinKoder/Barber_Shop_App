package pl.mwisniewski.barber_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mwisniewski.barber_app.model.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
}
