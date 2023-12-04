package javaFiles;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.event.DocumentEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Ryan Caudill
 */

public class ProjectListTester {
    private ProjectList PL = ProjectList.getInstance();
    private Project test = new Project("test");

    @Test
    public void testAddProjectLiteral() {
        assertEquals(PL.addProject(test), true);
        assertEquals(PL.getProject("test"), test);
    }

    @Test
    public void testAddNullProject() {
        int size = PL.getProjects().size();
        assertEquals(PL.addProject(null), false);
        assertEquals(size, PL.getProjects().size());
    }
    
    @Test
    public void testAddProject() {
        User uTest = new User(null, null, null, false, null);
        ArrayList<Column> cTest = new ArrayList<>();
        ArrayList<User> usTest = new ArrayList<>();
        assertEquals(PL.addProject("test", uTest, cTest, usTest), PL.getProject("test"));
    }

    @Test
    public void testAddProjectNullPart() {
        User uTest = new User(null, null, null, false, null);
        ArrayList<Column> cTest = new ArrayList<>();
        ArrayList<User> usTest = new ArrayList<>();
        assertEquals(PL.addProject(null, uTest, cTest, usTest), false);
        assertEquals(PL.addProject("test", null, cTest, usTest), false);
        assertEquals(PL.addProject("test", uTest, null, usTest), false);
        assertEquals(PL.addProject("test", uTest, cTest, null), false);
    }
}
