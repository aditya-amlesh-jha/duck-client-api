package com.adityajha.duck_client_api.service;

import com.adityajha.duck_client_api.model.NotificationEntity;
import com.adityajha.duck_client_api.repository.NotificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepo notificationRepo;

    public void addNotification(NotificationEntity notificationEntity){
        notificationRepo.save(notificationEntity);
    }
    public NotificationEntity getNotificationById(UUID notificationId){
        return notificationRepo.findById(notificationId).orElse(null);
    }
}
