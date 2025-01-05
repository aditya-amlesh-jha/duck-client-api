package com.adityajha.duck_client_api.repository;

import com.adityajha.duck_client_api.model.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationEntity, UUID> {
}