package com.dev.springdemo.customer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sunitc on 4/19/18.
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String emailAddress;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private List<Address> addresses;
}
