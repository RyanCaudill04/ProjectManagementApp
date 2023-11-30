/**
 * @author Ashya
 * @author Jacob Bagley
 */

package javaFiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

/*
 * @author Ashiya Branch
*/
public class UserListTester {
    private ArrayList<User> users = new ArrayList<User>();
    private UserList UL = UserList.getInstance();
    
    @BeforeEach
    public void setup() {
        UL = UserList.getInstance();
        UL.getUsers().clear();
        UL.addUser("AtticusMadden@gmail.com", "Atticus", "Madden", false, "passwordAM!");
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        UL.getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    void testHaveUserVaildEmail() {
        User hasAtticus = UL.getUserByEmail("AtticusMadden@gmail.com");
        assertNotNull(hasAtticus);
    }

    @Test
    void testHaveUserInvaildVaildEmail() {
        User hasLmao = UL.getUserByEmail("lmao@yeet.net");
        assertNull(hasLmao, "Null because user does not exist");
    }

    @Test
    void testHaveUserEmptyEmail() {
        User hasEmpty = UL.getUserByEmail(" ");
        assertNull(hasEmpty);
    }

    @Test
    public void testInvalidLogin() {
        User fact = UL.login("Pa1", "lmao@yeet.net");
        assertNull(fact, "You don't exist without being logged in");
    }

    @Test
    public void testNullLogin() {
        User fact = UL.login(null, null);
        assertNull(fact, "Does null truly nullify?");
    }

    @Test
    public void testVaildLogin() {
        User fact = UL.login("passwordAM!", "AtticusMadden@gmail.com");
        assertNotNull(fact);
    }

    @Test
    void testAddUserGeneratesValidId() {
        User newUser = UL.addUser("jenCater@gmail.com", "Jen", "Carter", false, "carterAm@");
        assertNotNull(newUser);
        assertNotNull(newUser.getID());
    }

    @Test
    void testaddUserInvaildUser() {
        User userInvaild = UL.addUser(null, null, null, false, null);
        assertNull(userInvaild);
    }

    @Test
    void testaddUserEmailExist() {
        User emailExist = UL.getUsers().get(0);
        User emailDuplicate = UL.addUser(emailExist.getEmail(), "Atticus", "Madden", false, "passwordAM!");
        assertNull(emailDuplicate);
    }

    @Test
    void testgetUserbyUUID() {
        User userExist = UL.getUsers().get(0);
        UUID userId = userExist.getID();
        User retrieveUser = UL.getUserByUUID(userId);
        assertNotNull(retrieveUser);
        assertEquals(userExist, retrieveUser);
    }

    @Test
    void testLoginFalied() {
        User wrongPassword = UL.login("Passwordam1", "AtticusMadden@gmail.com");
        assertNull(wrongPassword);
    }

    @Test
    void testUserdoesNotExist() {
        User dontExist = UL.login("passwordAM!", "MaddenAtticus@gmail.com");
        assertNull(dontExist);
    }

    @Test
    void testgetUser() {
        ArrayList<User> userList = UL.getUsers();
        assertNotNull(userList);
    }

    @Test
    void testsaveUsers() {
        User newUser = UL.addUser("jenCater@gmail.com", "Jen", "Carter", false, "carterAm@");
        UL.saveUsers();
        assertNotNull(newUser);
    }

}
