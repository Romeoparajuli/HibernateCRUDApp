
**`HibernateCRUDApp`**


# HibernateCRUDApp

A comprehensive CRUD (Create, Read, Update, Delete) application built using **Hibernate ORM** and **MySQL**. This project demonstrates how to perform efficient database operations with industry-level standards and provides a foundational understanding of Hibernate's capabilities.

---

## Features

- **Hibernate ORM** for seamless Java-to-Database interaction.
- **CRUD Operations**:
  - Create: Add new user details to the database.
  - Read: Retrieve and display user details.
  - Update: Modify existing user details.
  - Delete: Remove user records.
- **MySQL Integration** for data persistence.
- Proper entity mapping with Hibernate annotations.
- Configurable database schema management.
- Extensive logging for debugging and SQL query visualization.

---

## Tech Stack

- **Programming Language**: Java
- **ORM Framework**: Hibernate
- **Database**: MySQL
- **Tools**:
  - Maven (for dependency management)
  - MySQL Workbench (for database management)
  - IntelliJ IDEA/Eclipse (for development)

---

## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java JDK 8 or higher**
2. **MySQL Server**
3. **Maven**
4. **An IDE** (e.g., IntelliJ IDEA, Eclipse)

---

## Installation and Setup

Follow these steps to set up the project locally:

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/HibernateCRUDApp.git
   cd HibernateCRUDApp
   ```

2. **Configure Database**
   - Create a MySQL database named `springhibernate`.
   - Use the following SQL to verify the database:
     ```sql
     CREATE DATABASE springhibernate;
     USE springhibernate;
     ```
   - Ensure that the `hibernate.cfg.xml` file in the project has the correct database credentials:
     ```xml
     <property name="connection.username">root</property>
     <property name="connection.password">your_password</property>
     ```

3. **Build the Project**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   - Run the `App.java` file in your IDE.
   - The application will automatically connect to the database.

---

## Usage

### 1. Insert Operation
Uncomment the following block in `App.java` to insert a new user:
```java
User user = new User();
user.setName("John Doe");
user.setEmail("john.doe@example.com");
user.setGender("male");
user.setCity("New York");
user.setPhone("1234567890");
user.setPassword("password123");
session.save(user);
transaction.commit();
```

### 2. Read Operation
Retrieve a user by their ID:
```java
User user = session.get(User.class, 1);
if (user != null) {
    System.out.println(user);
} else {
    System.out.println("User not found.");
}
```

### 3. Update Operation
Update an existing user's details:
```java
User user = session.get(User.class, 1);
if (user != null) {
    user.setCity("San Francisco");
    session.saveOrUpdate(user);
    transaction.commit();
}
```

### 4. Delete Operation
Delete a user by their ID:
```java
User user = session.get(User.class, 1);
if (user != null) {
    session.delete(user);
    transaction.commit();
}
```

---

## Database Schema

The `User` entity maps to the following database schema:

| Column   | Data Type    | Description               |
|----------|--------------|---------------------------|
| `id`     | INT (PK, AI) | Unique identifier         |
| `name`   | VARCHAR(255) | User's full name          |
| `email`  | VARCHAR(255) | User's email address      |
| `phone`  | VARCHAR(20)  | User's phone number       |
| `gender` | VARCHAR(10)  | User's gender             |
| `city`   | VARCHAR(255) | User's city of residence  |
| `password`|VARCHAR(255) | User's password           |

---

## Project Structure

```plaintext
src/main/java/com/romeo/Main
├── App.java                # Main application class
├── Entity
│   └── User.java           # Entity class for 'User'
├── Config
│   └── HibernateConfig.xml # Hibernate configuration file
```

---

## Future Improvements

- Add more entity relationships (e.g., One-to-Many, Many-to-Many).
- Implement a service layer for better separation of concerns.
- Introduce unit testing with JUnit and Mockito.
- Integrate Spring Framework for dependency injection and AOP.
- Add a frontend interface using JSP/Thymeleaf.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Author

Developed by **Romeo Coder**  
Feel free to  connect on [youtube](https://www.youtube.com/@romeoparajuli33)).

---

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your improvements.
```

### Key Features of the README:
1. **Clear and professional tone**.
2. Structured sections for easy navigation.
3. Detailed setup instructions.
4. Code snippets for quick understanding.
5. Future improvements section for scalability.
6. Licensing and contributing information.

You can tweak the author's details and database credentials as per your requirements! Let me know if you'd like any additional customization. 😊
