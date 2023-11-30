/*
 * @author Jacob Bagley
 */

package javaFiles;

import static org.junit.jupiter.api.Assertions.*;


import java.beans.Transient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTester {
	private String title = "Test Task";
	private String taskType = "Generic";
	private ArrayList<Comment> comments = new ArrayList<Comment>();
	private ArrayList<User> assignedUsers = new ArrayList<User>();
	private Column column;
	private int priority = 1;
	private Date dueDate = new Date();
	private int leaderboardPoints = 1;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	UserList UL = UserList.getInstance();
	User user;
	Task task = new Task(title, comments, assignedUsers, priority, dueDate,
			leaderboardPoints);

	@BeforeClass
	public void oneTimeSetup() {

	}

	@AfterClass
	public void oneTimeTearDown() {

	}

	@BeforeEach
	public void setup() {
		title = "Test Task";
		taskType = "Generic";
		comments = new ArrayList<Comment>();
		assignedUsers = new ArrayList<User>();
		priority = 1;
		dueDate = new Date();
		leaderboardPoints = 1;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		UL = UserList.getInstance();
		user = UL.getUserByEmail("AtticusMadden@gmail.com");
		task = new Task(title, comments, assignedUsers, priority, dueDate,
				leaderboardPoints);
	}

	@AfterEach
	public void tearDown() {
	}

	@Test
	public void addUserToNullArrayList() {
		String fact = task.addUserToArray(user, null);
		assertEquals("Error, user list is null", fact);
	}////
    
    //@Test
    public void addUserTest() {
    // String fact = Task.addUserToArray("JohnDoe", );


    }//unfinished
    
    //@Test
    //public void makeCommentTester() {
    //    String fact = Task.makeComment("testing", "JohnDoe");
    //    assertEquals("testing","JohnDoe",fact);
    //}//needs to be an actual User object, not a name String.
	//in other words, this method cannot be invoked in the first place.
	/*
	 * java.lang.NullPointerException: Cannot invoke
	 * "java.util.ArrayList.add(Object)" because "users" is null
	 * at javaFiles.Task.addUserToArray(Task.java:36)
	 * at javaFiles.TaskTester.addUserTest(TaskTester.java:68)
	 * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 */

	@Test
	public void makeCommentTesterUserNull() {
		user = null;
		String fact = task.makeComment("testing", null);
		assertEquals("Comment not added, invalid user", fact);
	}// passing null user
	/*
	 * java.lang.NullPointerException: Cannot invoke "javaFiles.User.getEmail()"
	 * because "user" is null
	 * at javaFiles.Task.makeComment(Task.java:84)
	 * at javaFiles.TaskTester.makeCommentTesterUserNull(TaskTester.java:75)
	 * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 */

	@Test
	public void makeCommentTesterStringNull() {
		user = UL.getUserByEmail("AtticusMadden@gmail.com");
		String fact = task.makeComment(null, user);
		assertEquals("Comment not added, invalid comment", fact);
	}// passing null String
	/*
	 * org.opentest4j.AssertionFailedError: expected: [null] but was: [Added null by
	 * the user: AtticusMadden@gmail.com]
	 * at javaFiles.TaskTester.makeCommentTesterStringNull(TaskTester.java:83)
	 * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 */

	@Test
	public void assignTaskTest() { //PEBCAK
		Task task2 = new Task("testtask2");
		task2.assignedUsers.add(UL.getUserByEmail("AtticusMadden@gmail.com"));
		User fact = task2.assignTask("AtticusMadden@gmail.com");
		assertEquals(user, fact);
	}//expected: javaFiles.User@5af97850 returned: null

	@Test
	public void assignTaskTest2() { //PEBCAK
		ArrayList<User> control = new ArrayList<>();
		user = UL.getUserByEmail("AtticusMadden@gmail.com");
		control.add(user);
		task.assignedUsers = control;// this is not working as intended because...
		System.out.println(task.getAssignedUsers().get(0));
		System.out.println("testing");
		System.out.println(task.assignTask(user.getEmail()));// ... this is returning null, despite
		ArrayList<User> fact = task.getAssignedUsers();
		assertEquals(fact.get(0), control.get(0));
	}/*
		 * java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
		 * at
		 * java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
		 * at
		 * java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions
		 * .java:106)
		 * at
		 * java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
		 * at java.base/java.util.Objects.checkIndex(Objects.java:385)
		 */

	@Test
	public void assignDueDate(){
		task.setDueDate(dueDate);
		Date fact = task.getDate();
		assertEquals(fact, dueDate);
	}// "It just works" -Bethesda Guy
}
