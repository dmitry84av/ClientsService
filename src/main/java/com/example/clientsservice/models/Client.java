package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "clients")
public class Client {

    public void setAddress(Address address) {
    }

    public boolean getAddress() {
    }

    public enum Gender{
        NONE, MALE,FEMALE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String patronymic;
    @Column(nullable = false, columnDefinition = "int default 0")
    private Gender gender;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "date datetime")
    private LocalDateTime date;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Phone> phones;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "clients_accounts",
            joinColumns = @JoinColumn(name = "client_id", nullable = false,
                    foreignKey = @ForeignKey(name = "FK_clients")),
            inverseJoinColumns = @JoinColumn(name = "account_id", nullable = false,
                    foreignKey = @ForeignKey(name = "FK_accounts"))
    )
    private Set<Account> accounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Address getAddresses() {
        return addresses;
    }
    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "clients_address",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Address addresses;

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public Client(Integer id, String surname, String name, String patronymic, Gender gender, String email, Address addresses, Set<Phone> phones, Set<Account> accounts) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.email = email;
        this.addresses = addresses;
        this.phones = phones;
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(surname, client.surname) && Objects.equals(name, client.name) && Objects.equals(patronymic, client.patronymic) && gender == client.gender && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, gender, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
