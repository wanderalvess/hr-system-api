package br.com.wanderalvess.userapi.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //Constructor
    public User() {
    }

    public User(Long id, String name, String email, String password, Double hourlyPrice) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.hourlyPrice = hourlyPrice;
    }

    //Getter and Settes
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

    public Double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(Double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }
}

