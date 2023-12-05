/** This class is abandoned
 * @author Jacob Bagley
 * @author Gavin Humphries
 */

package javaFiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Locale;

public class TerminalUI {
    private Scanner kb = new Scanner(System.in);
    private ProjectSystemFACADE facade = new ProjectSystemFACADE();
    private Project project;
    private ProjectList PL = ProjectList.getInstance();
    private StringBuffer sb = new StringBuffer();
    private UserList UL = UserList.getInstance();
    private User user = null;
    private boolean exitUI = false;
    private Column column;
    private Task task = null;
    private String email = null;
    private String password = null;




    public TerminalUI(String email, String password) {
        this.email = email;
        this.password = password;
    }
//////////////////////////////////////////////////////////////
    public void runUI() {

        while (email == null && password == null) {
            System.out.println("Please select an option: (1) login, (2) sign up");

            if (kb.nextLine() == "1") {
                UILogin();
                break;
            } else if (kb.nextLine() == "2") {
                UISignUp();
                break;
            }
            System.out.println("Error: invalid input.");
        }

        UILogin(email, password);

        do {
            System.out.println(
                    "What do you want to do? \n" +
                            "1) Sign out \n" +
                            "2) Get a list of all users \n" +
                            "3) Get an existing project \n" +
                            "4) Change your password \n" +
                            "5) Get a list of projects \n" +
                            "6) Make a project \n" +
                            "7) View your points\n" +
                            "8) Exit program");            
            int answer = kb.nextInt();
            switch (answer) {
                case 1:
                    System.out.flush();
                    UISignOut();
                    break;
                case 2:
                    System.out.flush();
                    System.out.println(getUserArrayList()); 
                    break;
                case 3:
                    System.out.flush();
                    getProject();
                    break;
                case 4:
                    System.out.flush();
                    changePassword();
                    break;
                case 5:
                    System.out.flush();
                    getProjectArrayList();
                    break;
                case 6:
                    System.out.flush();
                    makeProject();
                    break;
                case 7:
                    System.out.flush();
                    System.out.println("Your points: " + user.getPoints());
                    break;
                case 8:
                    System.out.println("Exiting program");
                    exitUI = true;
                    break;
                default:
                    System.out.flush();
                    System.out.println("Invalid input");
                    break;
            }
        } while (exitUI == false);
        facade.exitProgram();
    } ////////////////////////////////////////////////////////////
    public void runProjectUI() {
        exitUI = true;
        while (exitUI) {
            System.out.flush();
            System.out.println("Current project: " + project.getName());
            System.out.println("What do you want to do? \n" +
                                  "1) Go back\n" + 
                                  "2) View scrum board\n" + 
                                  "3) Move task\n" +
                                  "4) Add column\n" +
                                  "5) Edit tasks \n");
            int answer = kb.nextInt();
            switch (answer) {
                case 1:
                    System.out.flush();
                    exitUI = true;
                    break;
                case 2:
                    System.out.flush();
                    scrumBoardView();
                    break;
                case 3:
                    System.out.flush();
                    moveTask();
                    break;
                case 4:
                    System.out.flush();
                    addColumn();
                    break;
                case 5:
                    System.out.flush();
                    taskManipulator();
                    break;
                default:
                    System.out.flush();
                    System.out.println("Invalid input");
                    break;
            }
        }
        exitUI = false;
        
    }
    public String UISignUp() {
        System.out.println("Enter your email");
        String email = kb.nextLine();
        System.out.println("Enter your first name");
        String firstName = kb.nextLine();
        System.out.println("Enter your last name");
        String lastName = kb.nextLine();

        // Constantly check if this user is the scrummaster of the project currently in

        System.out.println("Enter your password");
        String password = kb.nextLine();
        if(facade.signUp(email, firstName, lastName, false, password) == null){
            return "Sign up failed. Invalid information.";
        }
        else{
            this.user = UL.getUserByEmail(email);
            return "Sign up complete!";
        }
    }

    public String UILogin() {
        System.out.println("Enter your email");
        String email = kb.nextLine();
        System.out.println("Enter your password.");
        String password = kb.nextLine();
        if(facade.login(email, password) == null)
        {
            return "Invalid email or password";
        }else{
            this.user = UL.getUserByEmail(email);
            return "Login complete";
        }
      
    }
    //changed return type from string to boolean for scenario purposes
    public boolean UILogin(String email, String password) {
        this.email = email;
        this.password = password;
        if(facade.login(email, password) == null)
        {
            System.out.println("Login unsuccessful");
            return false;
        }else{
            this.user = UL.getUserByEmail(email);
            System.out.println("Login successful");
              return true;
        }
    }

    public void UISignOut(){
        facade.signOut();
        user = null;
        email = null;
        password = null;
        exitUI = false;
        System.out.println("Signed out!");
        runUI();
    }

    public String getUserArrayList() {

        ArrayList<User> userArray = facade.getAllUsers();

        for (int i = 0; i < facade.getAllUsers().size(); i++) {
            sb.append(userArray.get(i).getFirstName() + " " + userArray.get(i).getLastName());

            //formatting
            if (i != facade.getAllUsers().size() - 1) {
                sb.append(", ");
            } else if (i == facade.getAllUsers().size() - 1) {
                sb.append(".");
            }

        }
        String rv = sb.toString();
        userArray = null;
        sb.setLength(0);
        return rv;
    }

    public String getProjectArrayList(){
    ArrayList<Project> projects = new ArrayList<>();
        projects.addAll(0, PL.getProjects());
        for (int i = 0; i < projects.size(); i++) {
            sb.append((i + 1) + ") " + projects.get(i).getName() + "\n");
        }
        String rv = sb.toString();
        sb.setLength(0);
        return rv;
    }

    /*
    public String getProject(String name) {

        ArrayList<Project> projects = new ArrayList<>();
        projects = facade.getAllProjects();
        for (int i = 0; i < projects.size(); i++) {
            sb.append((i + 1) + ") " + projects.get(i).getName() + "\n");
        }
        one: {
            System.out.println("Here is a list of available projects: \n\n" + sb.toString());
            System.out.println("Please enter the name of the Project you desire:");
            kb.nextLine();
            String name = kb.nextLine();
            if (null == (PL.getProject(name))) {
                System.out.println("Error, project not found\n");
                break one;
            }
            project = PL.getProject(name);
            System.out.println("Current project: " + project.getName());
            runProjectUI();
        }
        sb.setLength(0);
        return project.getName();
    }
    */
    public Project getProject(String projectName){
        if(PL.getProject(projectName) == null){
            System.out.println("Error, project not found.");
            return null;
        }
        else{
            project = PL.getProject(projectName);
        }
        return project;
    }

    public String changePassword() {
        System.out.println("Enter your email");
        String inEmail = kb.nextLine();
      //user = UL.getUserByEmail(inEmail);
      //user = facade.getUser(inEmail);
        if (user != null) {
            System.out.println("Enter  old password");
            String oldPw = kb.nextLine();
            System.out.println("Enter your new password");
            String newPw = kb.nextLine();
            user.setPassword(newPw, oldPw);
        } else {
            return "Invalid email";
        }
        return "Changed password successfully";
    }


    //Project Methods
    //================================================================================================
    //assumes we are operating under a project that has been selected or created
    public String addColumn(String title) {
        //System.out.println("Please enter a title for the Column:");
        //String title = kb.next();
        project.addColumn(title);
        String rv = "Added column " + title + " to project " + project.getName();
        return rv;
    }

    //assumes we are operating under a project that has been selected or created
    public String removeColumn(){
        String rv = null;
        System.out.println("Please enter the name of the column you would like to remove");
        String name = kb.next();
        project.removeColumn(name);
        rv = "Removed column " + name;
        return rv;
    }

    //assumes we are operating under a project that has been selected or created
    public String renameColumn(){
        System.out.println("Please enter the name of the column you want to rename: ");
        String oldName = kb.next();
        System.out.println("Please enter the new name for the column: ");
        String newName = kb.next();
        return project.renameColumn(oldName, newName);
    }
    
    //assumes we are operating under a project that has been selected or created
    public String moveTask(String taskName, String taskColumn, String destColumn){
        //System.out.println("Enter the name of the task to be moved");
        //String taskName = kb.next();
        //System.out.println("Enter the name of the column the task is currently in");
        //String taskColumn = kb.next(); 
        //System.out.println("Enter the name of the column the task will move to");
        //String destColumn = kb.next();
        return project.moveTask(taskColumn, taskName, destColumn);
    }
    //===============================================================================================


    //Column Methods
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //assumes we are operating under a column that has been selected or created
    public String addTask() {
        System.out.println("Which column would you like to add the task to?");
        //show column options
        String name = kb.nextLine();
        column = project.getColumn(kb.nextLine());
        kb.nextLine();
        System.out.println("Enter the name of the task:");
        String title = kb.nextLine();
        System.out.println("Enter the priority of the task (1-3):");
        int priority = kb.nextInt();
        System.out.println("Enter the due date for the task(DD-MMM-YYYY): ");
        SimpleDateFormat formatter = new SimpleDateFormat("DD-MMM-YYYY", Locale.ENGLISH);
        String stringDate = kb.nextLine();
        Date dueDate = null;
        try {
            dueDate = formatter.parse(stringDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.println("Error formatting date.");
            e.printStackTrace();
        }
        System.out.println("Enter the points gained from finishing the task:");
        int leaderboardPoints = kb.nextInt();
        System.out.println("Enter the user that should complete this task:");
        String email = kb.nextLine();
        kb.nextLine();
        Task newTask = new Task(title);
        newTask.setDueDate(dueDate);
        newTask.addPoints(leaderboardPoints);
        newTask.assignUser(UL.getUserByEmail(email));
        newTask.setPriority(priority);
        column.addTask(newTask);
        return "Task created";
    }

    public String taskListView(String columnName){
        System.out.println("Please enter the name of the column containing the tasks: ");
        column = project.getColumn(kb.next());
        ArrayList<Task> tasks = column.TaskListView();
        for(int i = 0; i < tasks.size(); i++){
            sb.append(") " + tasks.get(i).getTitle() + "\n");
        }
        String rv = sb.toString();
        sb.setLength(0);
        return rv;
    }

    public Boolean removeTask(String removingTask){
        return column.removeTask(column.getTask(removingTask));
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public String taskManipulator(){//assumes user is in the correct project and column
        String rv = "";
        System.out.println("Please select what you would like to do: ");
        System.out.println("1) Add a user to task \n2) create a task \n3) comment on a task \n4) add point value to a task "); 
        System.out.println("5) Set task priority \n6) assign a user to a task \n7) set due date of a task \n8) unassign user from a task");
       //Are options 1 and 6 the same?
        //if(kb.nextInt() != 2 && ((0 < kb.nextInt() << 9) == true)){
       //     System.out.println("Enter the name of the task to be manipulated");
       //     task = column.getTask(kb.next());
       //}
        switch(kb.nextInt()){
            case 1:
                System.out.println("Enter the name of the task to be manipulated");
                task = column.getTask(kb.next());
                System.out.println("Enter the user's email");
                task.assignTask(UL.getUserByEmail(kb.next()), task);
            break;
            case 2:
                addTask();
              //  task.addPoints(0);
              //  task.addUserToArray(UL.getUserByEmail(kb.next()));
              //  task.setPriority(0);
              //  task.assignUser(UL.getUserByEmail(getProject()));
              //  task.setDate(task, null);
            break;
            case 3:
                System.out.println("Enter the name of the task to be manipulated");
                task = column.getTask(kb.next());
                System.out.println("Enter your comment");
                rv = task.makeComment(kb.next(), user);
            break;
            case 4:
                System.out.println("Enter the name of the task to be manipulated");
                task = column.getTask(kb.next());
                System.out.println("Please enter a point value (number)");
                rv = task.addPoints(kb.nextInt());
            break;
            case 5:
                System.out.println("Enter the name of the task to be manipulated");
                task = column.getTask(kb.next());
                System.out.println("Set a priority (0-3)");
               // if((-1 < kb.nextInt() < 4) == true){
                task.setPriority(kb.nextInt());
               // }
            break;
            case 6:

            break;
            case 7:
                System.out.println("Enter the name of the task to be manipulated");
                task = column.getTask(kb.next());
            break;
            case 8:
                System.out.println("Enter the name of the task to be manipulated");
                task = column.getTask(kb.next());
                System.out.println("Enter the users email");
                task.unassignTask(kb.nextLine());
            break;
            default:

            rv = "default";
        }
        return rv;
    }

    public String makeProject(String name, String SMEmail, String email, ArrayList<Column> columns, ArrayList<User> devs) {
        devs.add(facade.getUser(email));//May need to call UL object instead of facade
        Project newProject = new Project(columns, name, facade.getUser(SMEmail), devs);//go directly to facade
        PL.addProject(newProject);
        return "Made project";
    }
    public void scrumBoardView() {
        ArrayList<Column> columns = project.getColumns();
        for (Column c : columns) {
            System.out.println(c.getName());
            ArrayList<Task> tasks = c.getTasks();
            for (Task t : tasks) {
                System.out.println("\t- " + t.getTitle());
                ArrayList<Comment> comments = t.getComments();
                printComments(comments, 0);
            }
        }
    }
    
    public void printComments(ArrayList<Comment> comments, int i) {
        for (Comment c : comments) {
            for (int x = 0; x < i; x++) {
                System.out.print("\t");
            }
            System.out.println("\t\t- " + c.getBody());
            printComments(c.getComments(), i + 1);
        }
    }

}
