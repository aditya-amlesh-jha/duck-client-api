package com.adityajha.duck_client_api.controller;

import com.adityajha.duck_client_api.model.NotificationEntity;
import com.adityajha.duck_client_api.model.UserEntity;
import com.adityajha.duck_client_api.service.MessageService;
import com.adityajha.duck_client_api.service.NotificationService;
import com.adityajha.duck_client_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientNotificationController {
    private final NotificationService notificationService;
    private final UserService userService;
//    private final MessageService messageService;

    @PostMapping("/addNotification")
    public void addNotificationTemplate(@RequestBody NotificationEntity notificationEntity){
        notificationService.addNotification(notificationEntity);
    }

    @GetMapping("/findNotification/{notificationId}")
    public NotificationEntity getNotificationTemplate(@PathVariable UUID notificationId){
        System.out.println(notificationId);
        return notificationService.getNotificationById(notificationId);
    }


    @PostMapping("/addUser")
    public void addUser(@RequestBody UserEntity userEntity){
        userService.addUser(userEntity);
    }

    @PostMapping("/addUserList")
    public void addUserList(@RequestBody List<UserEntity> userEntityList){
        userService.addUserList(userEntityList);
    }

    @GetMapping("/findUser/{userId}")
    public UserEntity get(@PathVariable UUID userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/sendMessage")
    public void sendMessage(){

    }
}
