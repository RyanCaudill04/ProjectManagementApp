package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Task class manages all task features.
 * 
 * @author Gavin Humphries
 * @author Ashiya Branch
 */
public class Task {
    private String title;
    private TaskType taskType;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    ArrayList<User> assignedUsers = new ArrayList<User>();
    private Column column;
    private int priority;
    private Date dueDate;
    private int leaderboardPoints;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public Task(String title) {
        this.taskType = TaskType.GENERIC;
        this.title = title;
    }

    /*
     * Creates a task with the asked for information.
     * 
     * @param title the title of the task.
     * 
     * @param comments the comments of the task.
     * 
     * @param assignedUsers the assignedUsers of the task.
     * 
     * @param column the column of the task.
     * 
     * @param priority the proiority of the task.
     * 
     * @param dueDate the due date of the task.
     * 
     * @param leaderboardPoints the leaderboard points of the task.
     */
    public Task(String title, ArrayList<Comment> comments, ArrayList<User> assignedUsers, int priority, Date dueDate,
            int leaderboardPoints) {
        this.title = title;
        this.comments = comments;
        this.dueDate = dueDate;
        this.assignedUsers = assignedUsers;
        this.priority = priority;
        this.dueDate = dueDate;
        this.leaderboardPoints = leaderboardPoints;
        this.taskType = TaskType.GENERIC;
    }

    /*
     * Adds comments to task with related user and date.
     * 
     * @param comment the comment, users the user who create the comment.
     */
    public boolean makeComment(String comment, User user) {///////
        if(comment == null || comment == ""){
            return true;
        } else if (user == null){
            return false;
        }
        Comment newComment = new Comment(comment, user);
        comments.add(newComment);
        return true;
    }//no boolean dependencies

    /*
     * Adds users to the assigned users list.
     * 
     * @param user the added user, users the assigned users list.
     * 
     * @return a success message.
     */
    public boolean addUserToArray(User user, ArrayList<User> users) {
        if ((user == null)) {
            return false;
        } else if (users == null){
            return false;
        }
            users.add(user);
            return true;
    }//

    /*
     * Set leaderboard points of task.
     * 
     * @param leaderboardPoints the new leaderboardPoints.
     * 
     * @return a conformation message.
     */
    public boolean addPoints(int leaderboardPoints) {
        this.leaderboardPoints = leaderboardPoints;
        return true;
    }//no refactor needed

    /*
     * Set due date of task.
     * 
     * @param dueDate the due date of task.
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }//REFACTORED

    /*
     * Set the task type of task.
     * 
     * @param taskType the new task type.
     */
    // public void setTaskType(TaskType taskType) {
    // this.taskType = taskType;
    // }

    /*
     * Uses name to assign task to user.
     * 
     * @param name the name of the user assigned to task.
     * 
     * @return user name or null.
     */
    public boolean assignTask(User user) {
        if(user == null){//safety
            return false;
        }
        this.assignedUsers.add(user);
        return true;
    }//REFACTORED

    public void setPriority(int priority) {
        this.priority = priority;
    }//no refactor needed

    /*
     * Uses name to unassign task to user.
     * 
     * @param name the name of user to unassign to task.
     * 
     * @return true if user is unassigned, false if not.
     */
    public boolean unassignTask(String email) { //now uses email as PARAM
        User userRemove = null;
        for (User user : this.assignedUsers) {
            if (user.getEmail().equals(email)) {
                userRemove = user;
                if (userRemove != null) {
                    this.assignedUsers.remove(user);
                    return true;
                }
            }
        }
        return false;
    }//REFACTORED

    /*
     * Gets the title of a task.
     * 
     * @return the task title.
     */
    public String getTitle() {
        return this.title;
    }

    /*
     * Gets the comments of a task.
     * 
     * @return the task comments.
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }//further testing needed

    /*
     * Gets the list of users assigned to the task.
     * 
     * @return an arraylist of users.
     */
    public ArrayList<User> getAssignedUsers() {
        return this.assignedUsers;
    }// no refactoring needed

    /*
     * Gets the column the task is associated with.
     * 
     * @return the column.
     */
    public Column getColumn() {
        return this.column;
    }

    /*
     * Gets the priority of a task.
     * 
     * @return the task priority.
     */
    public int getPriority() {
        return this.priority;
    }

    /*
     * Gets the due date of a task.
     * 
     * @return the task due date.
     */
    public Date getDate() {
        return this.dueDate;
    }

    /*
     * Gets the leaderboard points of a task.
     * 
     * @return the leaderboard points.
     */
    public int getPoints() {
        return this.leaderboardPoints;
    }

    /*
     * Gets the task type.
     * 
     * @return the task type.
     */
    // public TaskType getTaskType() {
    // return taskType;
    // }

    public boolean assignUser(User user) {
        if (user == null) {
            return false;
        }
        assignedUsers.add(user);
        return true;
    }
}
