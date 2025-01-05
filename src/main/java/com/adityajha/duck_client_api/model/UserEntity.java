package com.adityajha.duck_client_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, unique = true)
    private String countryCode;
    @Column(nullable = false)
    private String subscriberNumber;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private Date dateCreated;
    private Date dateUpdated;

    @PrePersist
    public void setDateCreated(){
        this.dateCreated = new Date();
    }

    @PreUpdate
    public void setDateUpdated(){
        this.dateUpdated = new Date();
    }
}
