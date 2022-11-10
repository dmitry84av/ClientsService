package com.example.clientsservice.models;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false,length = 100)
    private  String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) && Objects.equals(address, address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_address_clients"))
    private Client client;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
