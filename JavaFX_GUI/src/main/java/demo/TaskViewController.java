package demo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.ProjectSystemFACADE;

public class TaskViewController implements Initializable{

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) { //populates text fields
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        for(int i = 0; i < facade.getTask().getAssignedUsers().size(); i++){
            sb2.append(facade.getTask().getAssignedUsers().get(i));
            if(i<facade.getTask().getAssignedUsers().size()){
                //sb2.append(", ");
            }
        }
        sb.append("Title: " + facade.getTask().getTitle() + "\n");
        sb.append("Priority: " + String.valueOf(facade.getTask().getPriority()) + "\n");
        sb.append("Devs: " + sb2.toString() + "\n");
        sb.append("Due: " + facade.getTask().getDate() + "\n");
        sb.append("Points: " + String.valueOf(facade.getTask().getPoints()) + "\n");
        
        PropertiesBody.setText(sb.toString());
        UsersBody.setText(sb2.toString());
        LabelBody.setText(facade.getTask().getTitle());
    }

    

}