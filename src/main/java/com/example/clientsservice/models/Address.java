package com.example.clientsservice.models;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
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
    //
    private  String apartment;

    public <E> Address(long l, int i, HashSet<E> es) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) && Objects.equals(region, address1.region) && Objects.equals(district,address1.district) && Objects.equals(city,address1.city) && Objects.equals(street,address1.street)&& Objects.equals(house,address1.house);
    }
    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_address_clients"))
    private Client client;

    @Override
    public String toString() {
        return String.format(
                "Address{id=%s, region=%s, district=%s, city=%s, street=%s, house=%s, apartment=%s}",
            id, region, district, city, street, house, apartment
        );
    }

    public void addAll(List<Address> addressList) {
    }
}
