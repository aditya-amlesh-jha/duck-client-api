package com.adityajha.duck_client_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor @Getter @Setter
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID notificationId;
    @Column(nullable = false)
    private String notificationContent;
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
