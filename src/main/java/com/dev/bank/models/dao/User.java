package com.dev.bank.models.dao;

import javax.persistence.*; //JPA
import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstName", nullable = false) //user.firstName
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "userId")
    private List<Account> accounts;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
