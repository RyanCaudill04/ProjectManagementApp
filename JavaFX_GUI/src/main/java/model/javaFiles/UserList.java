package javaFiles;
/*
 * @author Ashiya Branch 
*/

import java.util.ArrayList;
import java.util.UUID;

/* The class is a singleton that manages a list of users.  */
public class UserList {
    private ArrayList<User> users = new ArrayList<User>();
    private static UserList userList;

    /*
     * Loads users data from the dataloader.
     */
    private UserList() {
        users = DataLoader.getUsers();
    }

    /*
     * Retrieves the instance of the userlist.
     * 
     * @return userlist.
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    /*
     * Retrieves the stored list of users in the userlist.
     * 
     * @return arraylist of user objects.
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /*
     * Uses the UUID to retrieve a user.
     * 
     * @param the id is the UUID for the user.
     * 
     * @return user oject with an UUID, if not found return null.
     */
    public User getUserByUUID(UUID id) {//////////////////////////////////////////
        for (User user : users) {
            if (user.getID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * takes in an email and returns the user with that email
     * 
     * @param email to get user by
     * @return user with that email, null if no user exists
     */
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    /*
     * Authenticate a user with their email and password.
     * 
     * @param email is the user's email.
     * 
     * @param password is the user's password.
     * 
     * @return authenticates user object, null if there is a failed authentication.
     */
    public User login(String password, String email) /////////////////////////////////////
    {
        for (User user : userList.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /*
     * Saves the list of users to the datawriter.
     * 
     * @return true if the user data was successfully saved.
     */

    /*
     * Adds a new user to the userlist.
     * 
     * @param email for the user's email, firstName the user's first name, lastName
     * the user's last name, isMaster for the user's who are masters, password the
     * users password, id for user's UUID.
     * 
     * @return the new user object, null if information is not valid or email
     * already used.
     */
    public User addUser(String email, String firstName, String lastName, boolean isMaster, String password) {/////////////////////////////////////////
        if (email == null || firstName == null || lastName == null || password == null) {
            return null;
        }

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return null;
            }
        }
        UUID id = UUID.randomUUID();
        User newUser = new User(email, firstName, lastName, isMaster, password, id, 0);

        users.add(newUser);

        return newUser;
    }

    public void saveUsers() {
        DataWriter.saveUsers();
    }
}
