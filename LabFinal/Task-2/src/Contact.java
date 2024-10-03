import java.io.*;
import java.util.*;

class Contact {
    private String firstName;
    private String lastName;
    private String emailId;

    public Contact(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return emailId;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nEmail: " + emailId + "\n";
    }
}