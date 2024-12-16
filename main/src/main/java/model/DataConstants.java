package model;

import java.text.SimpleDateFormat;

public class DataConstants {
    // User class constants
    protected static final String USER_FILE_NAME = "JavaFX_GUI/src/main/java/JSONfiles/Users.json";
    protected static final String USERS = "users";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_POINTS = "points";
    protected static final String USER_ISMASTER = "isMaster";
    protected static final String USER_ID = "id";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_EMAIL = "email";
    // Project class constants
    protected static final String PROJECT_FILE_NAME = "JavaFX_GUI/src/main/java/JSONfiles/Projects.json";
    protected static final String PROJECT_COLUMNS = "columns";
    protected static final String PROJECT_NAME = "name";
    protected static final String PROJECT_MASTER = "scrumMaster";
    protected static final String PROJECT_DEVELOPERS = "developers";
    // Column class constants
    protected static final String COLUMN_NAME = "name";
    protected static final String COLUMN_TASKS = "tasks";
    // Task class constants
    protected static final String TASK_TITLE = "title";
    protected static final String TASK_COMMENTS = "comments";
    protected static final String TASK_USERS = "assignedUsers";
    protected static final String TASK_PRIORITY = "priority";
    protected static final String TASK_DUE_DATE = "dueDate";
    protected static final String TASK_POINTS = "leaderboardPoints";
    // Comment class constants
    protected static final String COMMENT_BODY = "body";
    protected static final String COMMENT_USER = "user";
    protected static final String COMMENT_COMMENTS = "comments";
    protected static final String COMMENT_DATE = "dateOfComment";
    // Date formatter
    protected static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
}
