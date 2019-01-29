package pl.mwisniewski.barber_app.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "anonymous_orders")
public class AnonymousOrder extends Order {

    @NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(nullable = false)
    private String surname;

    @Email
    @Column(nullable = false)
    @NotNull
    private String email;

    @Override
    public String toString() {
        return "AnonymousOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", service=" + service +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
