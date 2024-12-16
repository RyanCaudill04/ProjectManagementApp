package demo;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MyWorkController {

    @FXML
    private Button contactButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button leaderboardButton;

    @FXML
    private Button profileButton;

    @FXML
    private Button projectsButton;

    @FXML
    void goToHome(ActionEvent event) throws IOException{
        App.setRoot("ProjectView");
    }

    @FXML
    void goToLeaderboard(ActionEvent event) throws IOException {
        App.setRoot("LeaderboardView");
    }

    @FXML
    void goToProfile(ActionEvent event) throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    void gotToContact(ActionEvent event) throws IOException {
        App.setRoot("ContactUs");
    }

    @FXML
    void gotToProjects(ActionEvent event) throws IOException {
        App.setRoot("ProjectListView");
    }


}
