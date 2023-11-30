package javaFiles;
import java.io.IOException;
import java.util.Date;

/*
 *  Your name is Atticus Madden.
    You currently work for Code Mission Possible - A company who works on creating software solutions for clean energy.

    You are the SCRUM Manager for 3 different projects (Electric Missiles, Soap Free Washers, and Air Computers)
    Open Electric Missiles
    Add a new task "Initialize super algorithm to detonate at warp speed". Assign the task to Jeff Goldblum.
    Add a comment to the task "Avoid civilians Jeff!"
    Move the existing task of "Curve the metal to make a cylindrical shape" to the 'Doing' column.
    This task has the existing comments of "Not cylindrical enough" - by Jeff,
    and "What's a cylinder" by Atticus Madden.  
    Reply to Jeff's comment and say "How about you do it jeff",
    and re-assign the task from yourself to Jeff.
    Add a new column called "Abandoned"
    Move an existing task "Make impossible burger possible" which doesn't really relate to the project purpose to "Abandoned"
    Now print the scrum board to a txt file.... make it pretty.
 */



public class Driver {
        private ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        private Date date = new Date();

        public void run() throws IOException{
            System.out.println("\u001b[H\u001b[2J");
            System.out.println("Logging in as Atticus Madden");
            facade.login("AtticusMadden@gmail.com","passwordAM!");
            System.out.println("Printing scrum board: ");
            System.out.println();
            facade.scrumBoardView();
            System.out.println("Opening Electric Missiles");
            facade.openProject("Electric Missiles");
            facade.openColumn("Project Backlog");
            System.out.println("Adding task to Project Backlog:");
            System.out.println();
            facade.addTask("Initialize super algorithm to detonate at warp speed", 2, date, 5, "jgoldblum@gmail.com");
            facade.selectTask(3);
            System.out.println();
            System.out.println("Making comment ");
            System.out.println();
            facade.makeComment(facade.getTask(), "Avoid civilians Jeff! (unless it hurts profits)");
            facade.moveTask();
            facade.openColumn("Doing");
            System.out.println("Selecting comment to reply to");
            facade.selectTask(1);
            facade.selectComment(2);
            System.out.println("Making comment on comment");
            System.out.println();
            facade.makeComment("How about you do it Jeff");
            System.out.println("Creating column ");
            facade.addColumn("Abandoned");
            System.out.println("Moving task");
            facade.moveTask(1);
            System.out.println("Printing scrum board to file");
            facade.printBoardToFile();
            facade.signOut();
            facade.exitProgram();
        }


        public static void main(String[] args) throws IOException{
            Driver driver = new Driver();
            driver.run();
        }
}
