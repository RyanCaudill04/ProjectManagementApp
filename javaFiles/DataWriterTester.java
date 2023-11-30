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

public class DataWriterTester extends DataWriter {
    @Test
    public void testSaveUsers() {
      DataWriter.saveUsers();
    }

    @Test
    public void testSaveProjects() {
      DataWriter.saveProjects();
    }
}
