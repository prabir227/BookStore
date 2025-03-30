package com.bookStore.bookStore.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private ObjectId id;
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private List<String> roles;
}
