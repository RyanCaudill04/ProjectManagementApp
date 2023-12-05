package javaFiles;

/**
 * @author Tristan Shillingford
 * Tester: Tristan Shillingford
 */
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ColumnTester {
    private ProjectList projects = ProjectList.getInstance();
    private ArrayList<Project> projectList = projects.getProjects();
    private Column column;
    private Project project;

    @BeforeEach
    public void setup() {
        project = projects.getProject("Electric Missiles");
        project.addColumn("Test Column");
        column = project.getColumn("Test Column");
    }

    @AfterEach
    public void tearDown() {
        project = null;
        column = null;
    }

    @Test
    public void TestAddTaskNull() {
        Task aTask = null;
        boolean taskAdded = column.addTask(aTask);
        assertFalse(taskAdded);
    }

    @Test
    public void TestTasksExistsNull() {
        Task aTask = null;
        boolean exists = column.taskExists(aTask);
        assertFalse(exists);
    }

    @Test
    public void TestGetTaskNull() {
        Task aTask = null;
        String testy = null;
        aTask = column.getTask(testy);
        assertEquals(null, aTask);
    }

}
