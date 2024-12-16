package demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import model.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ProjectViewController implements Initializable{
    private URL arg0;
    private ResourceBundle arg1;
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
    private HBox hbox_cols;

    @FXML
    void AddTaskBacklog(ActionEvent event) throws IOException{
        TextField newText = new TextField();
        columnBoxList.get(0).getChildren().add(newText);
        Button b = new Button("Submit");
        columnBoxList.get(0).getChildren().add(b);
        String text = "";
        EventHandler<ActionEvent> submitEvent = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                Label taskLabel = new Label();
                taskLabel.setWrapText(true);
                taskLabel.getStyleClass().add("task");
                columnBoxList.get(0).getChildren().remove(newText);
                columnBoxList.get(0).getChildren().remove(b);
                Task newTask = new Task(newText.getText());
                taskLabels.put(taskLabel, newTask);
                columnBoxList.get(0).getChildren().add(taskLabel);
                columnBoxes.get(columnBoxList.get(0)).addTask(newTask);
            }
        };
        DataWriter.saveProjects();
        b.setOnAction(submitEvent);
        initialize(arg0, arg1);
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
    private void enableDragandDrop(Label aLabel){
        aLabel.setOnDragDetected(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event){
                        Dragboard db = aLabel.startDragAndDrop(TransferMode.ANY);
                        ClipboardContent content = new ClipboardContent();
                        content.putString(aLabel.getText());
                        db.setContent(content);
                        draggedTask = taskLabels.get(aLabel);
                        event.consume();
                    }
                });
    } 
    public Task draggedTask;
    public Map<VBox, Column> columnBoxes = new HashMap<>();
    public Map<Label, Task> taskLabels = new HashMap<>();
    ArrayList<VBox> columnBoxList = new ArrayList();
   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.arg0 = arg0;
        this.arg1 = arg1;
        ProjectSystemFACADE facade = ProjectSystemFACADE.getInstance();
        //get the current user from the facade
        User user = facade.getUser();
        Project project = facade.getProjectByName("Electric Missiles");//implement
        ArrayList<Column> columns = project.getColumns();
        columnBoxes = new HashMap<>();
        taskLabels = new HashMap<>();
        columnBoxList = new ArrayList<>();

        for(Column column : columns){
            System.out.println("Column " + column);
            VBox columnBox = new VBox();
            columnBoxes.put(columnBox, column);
            columnBox.getStyleClass().add("column");
            columnBox.setPadding(new Insets(10,10,10,10));
            columnBox.setAlignment(Pos.TOP_CENTER);
            columnBox.setMinWidth(300);
            columnBoxList.add(columnBox);
            columnBox.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event){
                    if(event.getGestureSource() != columnBox && event.getDragboard().hasString()){
                        event.acceptTransferModes(TransferMode.MOVE);
                    }

                    event.consume();
                }
                
            });
            columnBox.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event){
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if(db.hasString()){
                        Label aLabel = new Label();
                        aLabel.setWrapText(true);
                        aLabel.setText(db.getString());
                        aLabel.getStyleClass().add("task");
                        columnBox.getChildren().add(aLabel);
                        columnBoxes.get(columnBox).addTask(draggedTask);
                        DataWriter.saveProjects();
                        aLabel.setOnDragDone(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event){
                                if(event.getTransferMode() == TransferMode.MOVE){//Get data, Declare new Task, add task to column (where moved),
                                                                                 // remove from previous Column, save to JSON
                                    columnBox.getChildren().remove(aLabel);
                                    columnBoxes.get(columnBox).removeTask(taskLabels.get(aLabel));
                                    DataWriter.saveProjects();
                                }
                                 event.consume();
                            }
                         });   
                        enableDragandDrop(aLabel);
                        success = true;
                    }
                    event.setDropCompleted(success);

                    event.consume();
                }
                
            });

            hbox_cols.getChildren().add(columnBox);
            hbox_cols.setSpacing(20);
            
            Label title = new Label();
            title.getStyleClass().add("column_title");
            title.setText(column.getName());
            columnBox.getChildren().add(title);

        ArrayList<Task> tasks = column.getTasks();
        
        for(Task task : tasks){
        	Label taskLabel = new Label();
            taskLabels.put(taskLabel, task);
            System.out.println(taskLabels.get(taskLabel).getTitle());
        	taskLabel.setWrapText(true);
            taskLabel.getStyleClass().add("task");
        	taskLabel.setText(task.getTitle());
        	columnBox.getChildren().add(taskLabel);
            enableDragandDrop(taskLabel);
            taskLabel.setOnDragDone(new EventHandler<DragEvent>() {
                public void handle(DragEvent event){
                    if(event.getTransferMode() == TransferMode.MOVE){
                        columnBox.getChildren().remove(taskLabel);
                        columnBoxes.get(columnBox).removeTask(taskLabels.get(taskLabel));
                        DataWriter.saveProjects();
                    }

                        event.consume();
                    }
                });   
        }
    }

    }
}

        