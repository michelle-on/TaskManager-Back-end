package com.example.taskManager.repositorys;


import com.example.taskManager.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUserName(String userName);

    @Override
    Optional<UserModel> findById(UUID uuid);
}
