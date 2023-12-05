package javaFiles;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
public class FacadeTester {
    private ProjectSystemFACADE facade =  ProjectSystemFACADE.getInstance();
    private Date aDate = new Date();
    @BeforeEach
    public void setup(){
        facade.openProject("Electric Missiles");
        facade.openColumn("Project Backlog");
        User user = facade.login("AtticusMadden@gmail.com","passwordAM!");
        facade.selectTask(1);
        facade.selectComment(1);
    }
    @AfterEach
    public void tearDown(){

    }

    @Test
    public void TestAddTaskInvalid(){
        boolean taskAdded = facade.addTask(null, -3, null, -4, null);
        assertFalse(taskAdded);
    }
    @Test
    public void TestSelectCommentLessThanOne(){
        boolean commentSelected = facade.selectComment(0);
        assertFalse(commentSelected);
    }
    @Test
    public void TestSelectTaskLessThanOne(){
        boolean taskSelected = facade.selectTask(0);
        assertFalse(taskSelected);
    }
    @Test
    public void TestSelectCommentForBigNumber(){
        boolean commentSelected = facade.selectComment(2);
        assertFalse(commentSelected);
    }
    @Test
    public void TestSelectTastForBigNumber(){
        boolean taskSelected = facade.selectTask(2);
        assertFalse(taskSelected);
    }
    @Test
    public void TestAddTaskNegativePoints(){
        facade.addTask("Testing", 2, aDate, -3, "jgoldblum@gmail.com");
        facade.selectTask(2);
        int testPoints = facade.getTask().getPoints();
        assertEquals(0, testPoints);
    }
    @Test
    public void TestAddTaskNullTitle(){
       boolean taskAdded = facade.addTask(null, 2, aDate, -3, "jgoldblum@gmail.com");
       assertFalse(taskAdded);
    }
    @Test
    public void TestMakeCommentNullTask(){
        facade.makeComment(null,"Test comment");
    }
    @Test
    public void TestMakeCommentNullBody(){
        facade.makeComment(null);
    }
}

