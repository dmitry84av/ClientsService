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
    private  Long id;
    //область
    @Column(nullable = false)
    private  String region;
    //район
    @Column(nullable = false)
    private  String district;
    //город
    @Column(nullable = false)
    private  String city;
    //улица
    @Column(nullable = false)
    private  String street;
    //номер дома
    @Column(nullable = false)
    private  String house;
    //квартира
    private String apartment;
    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_address_clients"))
    private Client client;
}
