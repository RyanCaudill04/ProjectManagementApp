package demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Project;
import model.ProjectSystemFACADE;
import model.User;
import java.util.ArrayList;

public class ProjectViewController implements Initializable{

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        //get the current user from the facade
        User user = facade.getUser();
        Project project = facade.getProjectByName();//implement
        ArrayList<Column> columns = project.getColumns();

        for(Column column : columns){
            System.out.println("Column " + column);
            Vbox columnBox = new VBox();
            columnBox.getStyleClass().add("column");
            hbox_cols.getChildren.add(columnBox);
            hbox_cols.setSpacing(10);
            Label title = new Label();
            title.getStyleClass().add("column_title");
            title.setText(column.getColumnName());
            columnBox.getChildren().add(title);

        }


        ArrayList<Task> tasks = column.getTasks();
        
        for(Task task : tasks){
        	Label taskLabel = new Label();
        	taskLabel.setWrapText(true);
        	taskLabel.setText(task.getName());
        	columnBox.getChildren().add(taskLabel);
        }

    }
}
