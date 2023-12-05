package javaFiles;
/**
 * @author Jacob Bagley
 */

public class ClassConstruction extends Task{

    private String requirements;

    public ClassConstruction(String title, String requirements){
        super(title);
        this.requirements = requirements;
    }

    public String getRequirements() {
        return this.requirements;
    }
}
