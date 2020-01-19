package com.dev.springdemo.customer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunitc on 4/19/18.
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "created_on")
    @CreatedDate
    private Date createdOn;

    @Column(name = "updated_on")
    @LastModifiedDate
    private Date updatedOn;

    public void setAddresses(List<Address> addresses) {
        if(this.addresses == null) {
            this.addresses = new ArrayList<>();
        }else {
            this.addresses.clear();
        }
        this.addresses.addAll(addresses);
    }
}
