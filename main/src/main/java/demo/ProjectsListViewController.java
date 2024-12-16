package demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.*;

public class ProjectsListViewController implements Initializable{

    @FXML
    private Button ButtonContactUs;

    @FXML
    private Button ButtonHome;

    @FXML
    private Button ButtonLeaderboard;

    @FXML
    private Button ButtonMyWork;

    @FXML
    private Button ButtonProfile;

    @FXML
    private Button ButtonProjects;

    @FXML
    private Button MakeNewProject;

    @FXML
    private Text lbl_title;

    @FXML
    private Button openElectricMissiles;

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


    @FXML
    void openNewProjectDialog(ActionEvent event) { //needs a pop-up text box implemented for all project fields

    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        //get the current user from the facade
        User user = facade.getUser();
        
        String firstName = user.getFirstName();
        lbl_title.setText("Welcome " + firstName);
    }

}
