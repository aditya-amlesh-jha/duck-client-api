package com.adityajha.duck_client_api.repository;

import com.adityajha.duck_client_api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, UUID> {
    List<UserEntity> findByEmailLike(String emailPattern);
}
