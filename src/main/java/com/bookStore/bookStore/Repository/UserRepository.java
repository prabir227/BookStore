package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmail(@NonNull String email);
}
