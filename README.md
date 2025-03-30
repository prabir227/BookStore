# Bookstore Application Backend

This is a Spring Boot-based backend application for managing a bookstore. It provides secure API endpoints for users to sign up, log in, and manage books. JWT authentication is implemented to ensure secure access.

## Features
- User authentication using JWT tokens
- Create, update, delete, and retrieve books
- Filter books by author, category, and rating
- Search books by title
- Error handling and proper HTTP responses

---

## Prerequisites
- Java 17 or later
- IntelliJ IDEA or any IDE supporting Spring Boot
- Maven
- Postman (for API testing)

---

## Installation and Setup

1. **Clone the Repository:**
```bash
hthttps://github.com/prabir227/BookStore.git
```

Or download the ZIP file and extract it.

2. **Open in IDE:**
- Open IntelliJ IDEA and import the project as a Maven project.
- Ensure all dependencies from the `pom.xml` file are downloaded.

3. **Run the Application:**
- Go to the `BookStoreApplication.java` file and run it.

---

## API Endpoints

### **Authentication APIs**

#### 1. **Sign Up**
- **URL:** `POST /public/signup`
- **Description:** Create a new user account.
- **Request Body:**
```json
{
  "name": "John Doe",
  "email": "johndoe@example.com",
  "password": "password123"
}
```
- **Response:** HTTP 201 Created

#### 2. **Login**
- **URL:** `POST /public/login`
- **Description:** Log in using email and password to receive a JWT token.
- **Request Body:**
```json
{
  "email": "johndoe@example.com",
  "password": "password123"
}
```
- **Response:**
```json
{
  "token": "<jwt_token>"
}
```

---

### **Book Management APIs**
*All the following endpoints require JWT authentication. Include the token in the `Authorization` header.*

```http
Authorization: Bearer <jwt_token>
```

#### 1. **Add Book**
- **URL:** `POST /books/addbook`
- **Request Body:**
```json
{
  "title": "Spring Boot in Action",
  "author": "Craig Walls",
  "category": "Programming",
  "rating": 4.5
}
```
- **Response:** HTTP 201 Created

#### 2. **Update Book by ID**
- **URL:** `PUT /books/updateBookById/{id}`
- **Description:** Update book details using the book ID.
- **Response:** HTTP 200 OK

#### 3. **Delete Book by ID**
- **URL:** `DELETE /books/deleteBookById/{id}`
- **Response:** HTTP 200 OK

#### 4. **Get All Books**
- **URL:** `GET /books/getAllBooks`
- **Response:** List of all books

#### 5. **Get My Books**
- **URL:** `GET /books/getMyBooks`
- **Response:** List of books added by the authenticated user

#### 6. **Filter by Author**
- **URL:** `GET /books/filterByAuthor/{author}`
- **Response:** List of books by the specified author

#### 7. **Filter by Category**
- **URL:** `GET /books/filterByCategory/{category}`
- **Response:** List of books in the specified category

#### 8. **Filter by Rating**
- **URL:** `GET /books/filterByRating/{rating}`
- **Response:** List of books with a specified rating or higher

#### 9. **Search by Title**
- **URL:** `GET /books/search/{title}`
- **Response:** List of books matching the title

---

## Error Handling
- Proper error responses are returned with appropriate HTTP status codes.
    - `400 Bad Request`: Invalid input or authentication failure.
    - `404 Not Found`: Resource not found.
    - `500 Internal Server Error`: Unexpected server-side error.

---

## Conclusion
This backend application provides a secure and efficient way to manage books with complete authentication and authorization using JWT. Feel free to explore and extend the application further!

