package pl.mwisniewski.barber_app.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    public Service service;

    @Column(name = "order_create")
    public LocalDateTime dateOfCreatingOrder;

    @Column(name = "order_acceptance")
    public LocalDateTime dateOfOrderAcceptance;

    @Column(name = "order_contract")
    public LocalDateTime dateOfOrderContract;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @PrePersist
    public void prePersist() {
        this.dateOfCreatingOrder = LocalDateTime.now();
        this.dateOfOrderAcceptance = null;
    }

    @PreUpdate
    public void preUpdate() {
        this.dateOfOrderAcceptance = LocalDateTime.now();
    }

    public LocalDateTime getDateOfCreatingOrder() {
        return dateOfCreatingOrder;
    }

    public void setDateOfCreatingOrder(LocalDateTime dateOfCreatingOrder) {
        this.dateOfCreatingOrder = dateOfCreatingOrder;
    }

    public LocalDateTime getDateOfOrderAcceptance() {
        return dateOfOrderAcceptance;
    }

    public void setDateOfOrderAcceptance(LocalDateTime dateOfOrderAcceptance) {
        this.dateOfOrderAcceptance = dateOfOrderAcceptance;
    }

    public LocalDateTime getDateOfOrderContract() {
        return dateOfOrderContract;
    }

    public void setDateOfOrderContract(LocalDateTime dateOfOrderContract) {
        this.dateOfOrderContract = dateOfOrderContract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
