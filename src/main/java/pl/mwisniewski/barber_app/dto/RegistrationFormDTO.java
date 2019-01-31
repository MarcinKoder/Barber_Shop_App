package pl.mwisniewski.barber_app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationFormDTO {

    @NotNull
    @Email
    private String email;
    @NotNull @Size(min =3)
    private String name;
    @NotNull @Size(min =3)
    private String surname;
    @NotNull @Size(min = 3, max = 20)
    private String password;
    @NotNull @Size(min = 3, max = 20)
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
