package com.example.clientsservice.models;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "users")
public class User {
    public enum Role{
        USER,ADMIN
    }
    public enum Status{
        CREATED, ACTIVE,BLOCKED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "int(1) default 0")
            /*columnDefinition = "enum('USER','ADMIN') default 'USER'"*/
    private Role role;

    @Column(nullable = false, columnDefinition = "int(1) default 0")
    private Status status;

}
