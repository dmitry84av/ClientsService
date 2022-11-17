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
    @Column(nullable = false)
    private  String region;
    @Column(nullable = false)
    private  String district;
    @Column(nullable = false)
    private  String city;
    @Column(nullable = false)
    private  String street;
    @Column(nullable = false)
    private  String house;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) && Objects.equals(region, address1.region) && Objects.equals(district,address1.district) && Objects.equals(city,address1.city) && Objects.equals(street,address1.street)&& Objects.equals(house,address1.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }

    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_address_clients"))
    private Client client;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
