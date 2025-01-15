package com.romeo.Main;

import javax.persistence.Id; // Imports JPA annotation for primary key.
import org.hibernate.*; // Imports Hibernate core classes.
import org.hibernate.cfg.Configuration; // Imports Hibernate configuration class.
import com.romeo.Main.Entity.User; // Imports the User entity class for ORM mapping.

/**
 * The main class of the application, demonstrating CRUD (Create, Read, Update, Delete) operations 
 * using Hibernate ORM. Each operation interacts with the database using Hibernate's session management.
 */
public class App {
    public static void main(String[] args) {

        // Step 1: Create a Hibernate Configuration object and configure it with the XML file.
        Configuration configuration = new Configuration();
        configuration.configure("com/Config/HiberNateConfig.xml"); // Loads the Hibernate configuration file.

        // Step 2: Build a SessionFactory from the Configuration.
        // The SessionFactory is a heavyweight object responsible for managing Hibernate sessions.
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Step 3: Open a session from the SessionFactory.
        // A session is used to interact with the database (e.g., to execute queries).
        Session session = sessionFactory.openSession();

        // Step 4: Begin a database transaction.
        // Transactions ensure data consistency during operations.
        Transaction transaction = session.beginTransaction();

        // ------ Insert Operation Example ------
        /*
        Uncomment this block to insert a new user into the database.
        It demonstrates setting entity properties and saving the entity.

        User user = new User(); // Create a new User entity.
        user.setName("romeo Coder"); // Set the name of the user.
        user.setGender("female"); // Set the gender of the user.
        user.setEmail("romeo@gmail.com"); // Set the email address of the user.
        user.setPassword("123456789"); // Set the user's password.
        user.setPhone("9865324512"); // Set the user's phone number.
        user.setCity("palpa"); // Set the city of the user.

        try {
            session.save(user); // Save the user to the database.
            transaction.commit(); // Commit the transaction.
            System.out.println("DETAILS ADDED SUCCESSFULLY");
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction in case of an error.
            System.out.println("DETAILS ADDED UNSUCCESSFULLY");
            e.printStackTrace();
        }
        */

        // ------ Select Operation Example ------
        /*
        Uncomment this block to retrieve a user from the database by ID.
        The `session.get` method fetches the entity by primary key.

        try {
            User user = session.get(User.class, 0); // Retrieve the user with ID 0.
            if (user != null) {
                System.out.println(user.getId()); // Print user ID.
                System.out.println(user.getName()); // Print user name.
                System.out.println(user.getEmail()); // Print user email.
                System.out.println(user.getPassword()); // Print user password.
                System.out.println(user.getPhone()); // Print user phone.
                System.out.println(user.getGender()); // Print user gender.
                System.out.println(user.getCity()); // Print user city.
            } else {
                System.out.println("No user found");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log any exceptions that occur during the fetch operation.
        }
        */

        // ------ Update Operation Example ------
        /*
        Uncomment this block to update an existing user's city in the database.

        try {
            User user1 = session.get(User.class, 2); // Retrieve the user with ID 2.
            user1.setCity("butwal"); // Update the city field.

            session.saveOrUpdate(user1); // Save or update the entity in the database.
            transaction.commit(); // Commit the transaction.
            System.out.println("Update successful");
            System.out.println(user1); // Print the updated user details.
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction in case of an error.
            e.printStackTrace(); // Log the exception.
            System.err.println("Update unsuccessful");
        }
        */

        // ------ Delete Operation Example ------
        /*
        Demonstrates deleting a user from the database by ID.
        The `session.delete` method removes the entity.

        In this case, user ID 4 is deleted.

        */
        try {
            User user1 = new User(); // Create a new User object.
            user1.setId(4); // Set the ID of the user to be deleted.

            session.delete(user1); // Delete the user from the database.
            transaction.commit(); // Commit the transaction.
            System.out.println("Delete successful");
            System.out.println(user1); // Print the deleted user details (for reference).
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction in case of an error.
            e.printStackTrace(); // Log the exception.
            System.err.println("Delete unsuccessful");
        }

        // Close the session after completing the operation.
        session.close();
    }
}
