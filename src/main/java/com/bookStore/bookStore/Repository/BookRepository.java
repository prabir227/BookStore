package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.entity.BookEntity;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<BookEntity, String> {
    Optional<BookEntity> findByUserId(@NonNull ObjectId userId);
    Optional<BookEntity> findByAuthor(@NonNull String author);
    Optional<BookEntity> findByTitle(@NonNull String title);
    Optional<BookEntity> findByCategory(@NonNull String category);
    Optional<BookEntity> findByRating(@NonNull Float rating);
}
