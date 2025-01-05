package com.adityajha.duck_client_api.service;

import com.adityajha.duck_client_api.model.UserEntity;
import com.adityajha.duck_client_api.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void addUser(UserEntity userEntity){
        userRepo.save(userEntity);
    }
    public void addUserList(List<UserEntity> userEntityList){
        userRepo.saveAll(userEntityList);
    }
    public UserEntity getUserById(UUID userId){
        return userRepo.findById(userId).orElse(null);
    }
}
