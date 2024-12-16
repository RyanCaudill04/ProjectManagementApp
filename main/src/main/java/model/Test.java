package model;
import java.util.ArrayList;

/**
 * @author Gavin Humphries
 */

public class Test extends Task {
    private ArrayList<String> tests;
    private String requirements;

    public Test(String title, String requirements) {
        super(title);
        this.requirements = requirements;
    }
    public void removeTest(String test) {
        
    }
    public ArrayList<String> getTests() {
        return this.tests;
    }
    public String getRequirements() {
        return this.requirements;
    }
}
