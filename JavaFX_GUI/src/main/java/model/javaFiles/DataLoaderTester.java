package javaFiles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ryan Caudill
 */

public class DataLoaderTester extends DataLoader {
    @Test
    public void testGetUsers() {
      DataLoader.getUsers();
    }
    @Test
    public void testGetProjects() {
      DataLoader.getProjects();
    }

}
