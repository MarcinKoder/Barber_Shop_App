package pl.mwisniewski.barber_app.model;


import javax.persistence.*;

@Entity
@Table(name = "users_orders")
public class UserOrder extends Order {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
