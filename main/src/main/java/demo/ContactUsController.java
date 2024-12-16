package demo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ContactUsController {
    
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
    private TextField txt_first_name;
    
    @FXML
    private TextField txt_first_name1;
    
    @FXML
    private TextField txt_last_name;

    @FXML
    private Button SendMessage;

    @FXML
    private AnchorPane signup_pane;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txt_message;

    //@FXML
    //void btnSignupClicked(MouseEvent event) { //Why is there a signup method on Contact Us?
    //}

    @FXML
    void submitMessage(ActionEvent event) {

    }

    @FXML//This is broken, not sure why...
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
