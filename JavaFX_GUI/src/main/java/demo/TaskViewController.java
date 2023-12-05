package demo;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class TaskViewController {

    @FXML
    private Text LabelBody;

    @FXML
    private Text PropertiesBody;

    @FXML
    private Text UsersBody;

    @FXML
    private Button ContactUs;

    @FXML
    private Button Home;

    @FXML
    private Button Leaderboard;

    @FXML
    private Button MyWork;

    @FXML
    private Button Profile;

    @FXML
    private Button Projects;
    
    
    
    @FXML
    void gotoContactUs(ActionEvent event) throws IOException {
        App.setRoot("ContactUs");
    }

    @FXML
    void gotoHome(ActionEvent event) throws IOException {
        App.setRoot("ProjectView");
    }

    @FXML
    void gotoLeaderboard(ActionEvent event) throws IOException {
        App.setRoot("LeaderboardView");
    }

    @FXML
    void gotoMyWork(ActionEvent event) throws IOException {
        App.setRoot("TaskView");
    }

    @FXML
    void gotoProfile(ActionEvent event) throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    void gotoProjectListView(ActionEvent event) throws IOException {
        App.setRoot("ProjectListView");
    }

    

}