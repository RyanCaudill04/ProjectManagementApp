package javaFiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Gavin Humphries
 * 
 * 
 */
public class CommentTester {
    private Project project;
    private Column column;
    private Task task;
    private Comment comment;
    private ProjectList projects = ProjectList.getInstance();
    private ArrayList<Project> projectList = projects.getProjects();
    private ArrayList<User> assignedUsers = new ArrayList<User>();
    private int priority;
    private Date dueDate;
    private int leaderboardPoints;
    private User user1;


    //public CommentTester(String body, User user) {
        //super(body, user);
        // TODO Auto-generated constructor stub
    //}

    @BeforeClass
    public void oneTimeSetup() {        
        
    }

    @AfterClass
    public void oneTimeTearDown() {

    }

    @BeforeEach
    public void setup() {
        // runs before each test
        user1 = new User("email@email.com", "firstName", "lastName", false, "password");
        task = new Task("Test task");
        project = projects.getProject("Electric Missiles");
        project.addColumn("Test Column");
        column = project.getColumn("Test Column");
        column.addTask(task);
        task = column.getTask("Test task");
        task.addUserToArray(user1, assignedUsers);
        task.getComments();
    }

    @AfterEach
    public void tearDown() {
        // runs after each test
        project = null;
        column = null;
        task = null;
    }

    @Test
    public void makeCommentTester() {
       String fact = comment.makeComment("test", user1);
       assertEquals("Added test by the user: email@email.com", fact);
    }

    @Test
    public void makeCommentNullTester() {
        String fact = comment.makeComment(null, user1);
        assertEquals(null, fact);
    }
    //return "Added " + comment + " by the user: " + user.getEmail();

    
}
