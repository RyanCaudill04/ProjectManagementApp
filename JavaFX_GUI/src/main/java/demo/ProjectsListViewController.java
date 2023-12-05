package demo;

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
    private Text lbl_title;

    @FXML
    void gotoContactUs(ActionEvent event) {

    }

    @FXML
    void gotoHome(ActionEvent event) {

    }

    @FXML
    void gotoLeaderboard(ActionEvent event) {

    }

    @FXML
    void gotoMyWork(ActionEvent event) {

    }

    @FXML
    void gotoProfile(ActionEvent event) {

    }

    @FXML
    void gotoProjectListView(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        //get the current user from the facade

        lbl_title.setText("Welcome Portia");
    }

}
