package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;
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
    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "clients_address",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Address address;
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
