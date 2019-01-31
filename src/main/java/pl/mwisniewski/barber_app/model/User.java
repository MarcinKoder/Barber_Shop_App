package pl.mwisniewski.barber_app.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(nullable = false)
    private String surname;

    @Email
    @Column(nullable = false, unique = true)
    @NotNull
    private String email;

    @Column(nullable = false)
    @Size(min = 5)
    @NotNull
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserOrder> userOrderList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserOrder> getUserOrderList() {
        return userOrderList;
    }

    public void setUserOrderList(List<UserOrder> userOrderList) {
        this.userOrderList = userOrderList;
    }
}
