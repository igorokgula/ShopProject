package com.shop.presentation.form;
import org.hibernate.validator.constraints.Length;
/**
 * Created by Igor on 27.06.2015.
 */
public class RegistrationForm {
    @Length(min = 4, max = 15)
    private String username;

    @Length(min = 4, max = 15)
    private String password;

    @Length(min = 4, max = 15)
    private String passwordConfirmation;

    @Length(min = 4, max = 15)
    private String name;

    private Integer age;

    @Length(min = 4, max = 30)
    private String address;

    public RegistrationForm() {}

    public RegistrationForm(String username, String password, String passwordConfirmation, String name, Integer age, String address) {
        this.username = username;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean passwordsMatch() {
        return password.equals(passwordConfirmation);
    }

    @Override
    public String toString() {
        return "RegistrationForm{" + "username=" + username + ", password=" + password +
                ", passwordConfirmation=" + passwordConfirmation + ", name=" + name + ", age=" + age + ", address=" + address +  '}';
    }
}
