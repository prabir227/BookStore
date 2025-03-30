package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.Repository.BookRepository;
import com.bookStore.bookStore.Services.BookService;
import com.bookStore.bookStore.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    BookService bookService;
    @PostMapping("/addbook")
    public ResponseEntity<?> addBook(@RequestBody BookEntity book) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        bookService.addBook(book,email);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/updateBookById/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable String id) {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            bookService.updateBookById(id,email);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable String id) {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            bookService.deleteBookById(id,email);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            List<BookEntity> books = bookService.getAllBooks();
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getMyBooks")
    public ResponseEntity<?> getMyBooks(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String email = authentication.getName();
            Optional<BookEntity> books = bookService.getMyBooks(email);
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/filterByAuthor/{author}")
    public ResponseEntity<?> filterByAuthor(@PathVariable String author){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Optional<BookEntity> books = bookService.filterBYAuthor(author);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/filterByCategory/{category}")
    public ResponseEntity<?> filterByCategory(@PathVariable String category){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Optional<BookEntity> books = bookService.filterBYCategory(category);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/filterByRating/{rating}")
    public ResponseEntity<?> filterByCategory(@PathVariable Float rating){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Optional<BookEntity> books = bookService.filterBYRating(rating);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/search/{title}")
    public ResponseEntity<?> search(@PathVariable String title){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Optional<BookEntity> books = bookService.search(title);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
