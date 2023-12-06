package demo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProjectViewController {

    @FXML
    private Button ButtonAddTaskBacklog;

    @FXML
    private Button ButtonContactUs;

    @FXML
    private Button ButtonDone;

    @FXML
    private Button ButtonHome;

    @FXML
    private Button ButtonInProgress;

    @FXML
    private Button ButtonLeaderboard;

    @FXML
    private Button ButtonMyWork;

    @FXML
    private Button ButtonProfile;

    @FXML
    private Button ButtonProjects;

    @FXML
    private Button ButtonToDo;

    @FXML
    void AddTaskBacklog(ActionEvent event) {

    }

    @FXML
    void AddTaskInProgress(ActionEvent event) {

    }

    @FXML
    void AddTaskToDo(ActionEvent event) {

    }

    @FXML
    void addTaskToDone(ActionEvent event) {

    }

    @FXML
    void getUserProfile(ActionEvent event) {

    }

    @FXML
    void goHome(ActionEvent event) {

    }

    @FXML
    void openLeaderboard(ActionEvent event) {

    }

    @FXML
    void openMyWork(ActionEvent event) {

    }

    @FXML
    void openProjectListView(ActionEvent event) {

    }

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
