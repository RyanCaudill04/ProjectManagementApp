package model;
/**
 * @author Jacob Bagley
 */


public class FeatureAddition extends Task{

    private String additions;

    public FeatureAddition(String additions, String title){
        super(title);
        this.additions = additions;
    }
    public String getAdditions() {
        return this.additions;
    }

}
