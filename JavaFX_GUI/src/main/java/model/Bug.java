package model;

/**
 * @author Jacob Bagley
 */

public class Bug extends Task {

    private String repoSteps;
    private String bugLocation;
    private String tester;

    Bug(String title, String repoSteps, String tester, String bugLocation) {
        super(title);
        this.repoSteps = repoSteps;
        this.tester = tester;
        this.bugLocation = bugLocation;
    }

    public String getRepoSteps() {
        return this.repoSteps;
    }

    public String getBugLocation() {
        return this.bugLocation;
    }

    public String getTester() {
        return this.tester;
    }

}
