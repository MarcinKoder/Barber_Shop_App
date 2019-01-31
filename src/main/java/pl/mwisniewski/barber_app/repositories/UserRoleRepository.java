package pl.mwisniewski.barber_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mwisniewski.barber_app.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
