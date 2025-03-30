package com.bookStore.bookStore.Services;

import com.bookStore.bookStore.Repository.BookRepository;
import com.bookStore.bookStore.Repository.UserRepository;
import com.bookStore.bookStore.entity.BookEntity;
import com.bookStore.bookStore.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<?> addBook(BookEntity book, String email ) {
        try{
            book.setDate(new Date());
            UserEntity user = userRepository.findByEmail(email);
            book.setUserId(user.getId());
            bookRepository.save(book);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<?> updateBookById(String id, String email) {
        UserEntity user = userRepository.findByEmail(email);
        try {
            BookEntity book = bookRepository.findById(id).get();
            if (user.getId().toString().equals(book.getUserId().toString())) {
                bookRepository.save(book);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        }
        public ResponseEntity<?> deleteBookById(String id, String email) {
            UserEntity user = userRepository.findByEmail(email);
            try {
                BookEntity book = bookRepository.findById(id).get();
                if (user.getId().toString().equals(book.getUserId().toString())) {
                    bookRepository.delete(book);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        public List<BookEntity> getAllBooks() {
            return bookRepository.findAll();
        }
        public Optional<BookEntity> getMyBooks(String email) {
        try{
            UserEntity user = userRepository.findByEmail(email);
            return bookRepository.findByUserId(user.getId());
        }
        catch(Exception e){
            return Optional.empty();
        }
        }
        public Optional<BookEntity> filterBYAuthor(String author) {
            try{
                return bookRepository.findByAuthor(author);

            }
            catch(Exception e){
                return Optional.empty();
            }

        }
    public Optional<BookEntity> filterBYCategory(String category) {
        try{
            return bookRepository.findByAuthor(category);

        }
        catch(Exception e){
            return Optional.empty();
        }

    }
    public Optional<BookEntity> filterBYRating(Float rating) {
        try{
            return bookRepository.findByRating(rating);

        }
        catch(Exception e){
            return Optional.empty();
        }

    }
    public Optional<BookEntity> search(String title) {
        try{
            return bookRepository.findByTitle(title);

        }
        catch(Exception e){
            return Optional.empty();
        }

    }

}
