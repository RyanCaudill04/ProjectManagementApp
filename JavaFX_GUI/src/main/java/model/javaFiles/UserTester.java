package javaFiles;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import javaFiles.User;

/*
 * @author Ashiya Branch
 */
public class UserTester {

@AfterEach
public void tearDown() {
    DataWriter.saveUsers();
}

@Test
public void testupdateSetPassword(){
    User user = new User("AtticusMadden@gmail.com", "Atticus", "Madden", false, "passwordAM!", UUID.randomUUID(), 0);
    String oldPassword = "passwordAM!";
    String newPassword = "passwordAM!!";
    boolean update = user.setPassword(newPassword, oldPassword);
    assertEquals(update, "Password updated");
}

    
}

