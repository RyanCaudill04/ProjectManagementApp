package javaFiles;
/**
 * Refactoring task
 * @author Tristan
 */
public class Refactoring extends Task{
    private String changes;

    public Refactoring(String title, String changes){
        super(title);
        this.changes = changes;
    }

    public String getChanges() {
        return this.changes;
    }
}
