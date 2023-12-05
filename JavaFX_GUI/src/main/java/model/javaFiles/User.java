package javaFiles;
import java.util.ArrayList;
import java.util.UUID;

/*
 * The class represents a user and stores user information.
 * @author Ashiya Branch
 */
public class User {
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private int points;
    private boolean isMaster;
    private UUID id;

    /*
     * Creates user object with the information provided and an id.
     * @param email user's email, firstName user's first name, lastName user's last name, isMaster user who is the master, password user's password, id user's UUID.
     */
    public User(String email, String firstName, String lastName, boolean isMaster, String password, UUID id, int points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
        this.isMaster = isMaster;
        this.points = points;
    }

     /*
     * Creates user object with the information provided and a randomUUID.
     * @param email user's email, firstName user's first name, lastName user's last name, isMaster user who is the master, password user's password.
     */
    public User(String email, String firstName, String lastName, boolean isMaster, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isMaster = isMaster;
        this.id = UUID.randomUUID();
    }

    /*
     * Get the user's name.
     * @return user's first and last name.
     */
    public String getName() 
    {
        return firstName + " " + lastName;
    }
    /**
     * Get user first name
     * @return user first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * get user last name
     * @return user last name
     */
    public String getLastName() {
        return this.lastName;
    }
    /*
     * Get the user's email.
     * @returns user's email.
     */
    public String getEmail() {
        return email;
    }

    /*
     * Get the user's password.
     * @returns user's password.
     */
    public String getPassword() {
        return password;
    }

    /*
     * Get the user's newPassword.
     * @returns user's newPassword.
     */
    public boolean setPassword(String newPassword, String oldPassword) {
        if (this.password == newPassword) {
            this.password = newPassword;
            return true;
        }else {
            return false;
        }
        
    }

    /*
    * Get the user's points.
    * @returns user's points.
    */
    public int getPoints() {
        return this.points;
    }

    /*
    * Get the user's master.
    * @returns user's isMaster.
    */
    public boolean getIsMaster() {
        return this.isMaster;
    }

    /*
    * Get the user's id.
    * @returns user's id.
    */
    public UUID getID() {
        return this.id;
    }
}
