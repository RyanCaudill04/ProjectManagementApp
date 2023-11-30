package javaFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.event.DocumentEvent;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ryan Caudill
 */

public class ProjectTester extends Project {
  private User user1 = new User("email@email.com", "firstName", "lastName", false, "password");
  private Column column1 = new Column("column");
  private User user2 = new User("test@email.com", "first", "name", false, "password");
  private ArrayList<Column> columns = new ArrayList<>();
  private ArrayList<User> devs = new ArrayList<>();
  private Project test;
  @BeforeEach
  public void setUp() {
    columns.add(column1);
    devs.add(user1);
    devs.add(user2);
    test = new Project(columns, "test", user1, devs);
  }

  @Test
  public void testEmptyProjectConstructor() {
    Project test = new Project();
    assertEquals(test.getName(), "Untitled");
    assertEquals(test.getColumns().isEmpty(), true);
    assertEquals(test.getDevelopers().isEmpty(), true);
    assertEquals(test.getMaster(), null);
  }

  @Test
  public void testNameProjectConstructor() {
    Project test = new Project("Test");
    assertEquals(test.getName(), "Test");
    assertEquals(test.getColumns().isEmpty(), true);
    assertEquals(test.getDevelopers().isEmpty(), true);
    assertEquals(test.getMaster(), null);
  }

  @Test
  public void testNullProjectConstructor() {
    Project test = new Project(null, null, null, null);
    assertEquals(test.getName(), "Untitled");
    assertEquals(test.getColumns().isEmpty(), true);
    assertEquals(test.getDevelopers().isEmpty(), true);
    assertEquals(test.getMaster(), null);
  }

  @Test
  public void testRegularConstructor() {
    Project test = new Project(columns, "test", user1, devs);
    assertEquals(test.getName(), "test");
    assertEquals(test.getColumns().isEmpty(), false);
    assertEquals(test.getDevelopers().isEmpty(), false);
    assertEquals(test.getMaster(), user1);
  }

  @Test
  public void testAddStringColumn() {
    test.addColumn("test column");
    assertEquals(test.getColumns().size(), 2);
    assertEquals(test.getColumn("test column"), test.getColumns().get(1));
  }

  @Test
  public void testAddExistingColumn() {
    test.addColumn(column1);
    assertEquals(test.getColumns().size(), 1);
  }

  @Test
  public void testAddNewColumn() {
    test.addColumn(new Column("new"));
    assertEquals(test.getColumns().size(), 2);
    assertEquals(test.getColumn("new"), test.getColumns().get(1));
  }

  @Test
  public void testRemoveRealColumn() {
    boolean check = test.removeColumn(column1.getName());
    assertEquals(check, true);
    assertEquals(test.getColumns().size(), 0);
  }

  @Test
  public void testRemoveFakeColumn() {
    boolean check = test.removeColumn("Non-existent column");
    assertEquals(check, false);
    assertEquals(test.getColumns().size(), 2);
  }

  @Test
  public void testRenameFakeColumn() {
    String preCheckName = test.getColumns().get(0).getName();
    String check = test.renameColumn("Fake column", "arbitrary");
    String postCheckName = test.getColumns().get(0).getName();
    assertEquals(check, "");
    assertEquals(preCheckName, postCheckName);
  }

  @Test
  public void testRenameRealColumn() {
    String preCheckName = test.getColumns().get(0).getName();
    String check = test.renameColumn("column", "arbitrary");
    String postCheckName = test.getColumns().get(0).getName();
    assertEquals(check, "Column renamed");
    assertNotEquals(preCheckName, postCheckName);
  }

  @Test
  public void testRenameSameName() {
    String check = renameColumn("column", "column");
    assertEquals(check, "Column renamed");
  }

  @Test
  public void testMoveFakeColumn() {
    Task task = new Task("testtask");
    test.getColumn("column").addTask(task);
    assertEquals(test.moveTask("column", "testtask", "fake"), "Task or Column not found");
  }

  @Test
  public void testMoveFakeTask() {
    Column column2 = new Column("dest");
    test.addColumn(column2);
    assertEquals(test.moveTask("column", "fake", "dest"), "Task or Column not found");
  }
  
  @Test
  public void testMoveReakTask() {
    Column column2 = new Column("dest");
    test.addColumn(column2);
    Task task = new Task("task");
    test.getColumn("column").addTask(task);
    assertEquals(test.moveTask("column", "task", "dest"), "Task moved to destination column");
    assertEquals(test.getColumn("dest").getTask("task"), task);
  }
}
