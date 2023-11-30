package javaFiles;

import java.util.ArrayList;

/**
 * @author Ryan Caudill
 */
public class Project {
  private ArrayList<Column> columns;
  private String name;
  private User scrumMaster;
  private ArrayList<User> developers;

  public Project(){
    this.name = "Untitled";
    this.columns = new ArrayList<Column>();
    this.scrumMaster = null;
    this.developers = new ArrayList<User>();
  }

  public Project(String name){
    this.name = name;
    this.columns = new ArrayList<Column>();
    this.scrumMaster = null;
    this.developers = new ArrayList<User>();
  }

  public Project(ArrayList<Column> columns, String name, User scrumMaster, ArrayList<User> developers) {
    this.columns = columns;
    this.name = name;
    this.scrumMaster = scrumMaster;
    this.developers = developers;
  }
  
  public String addColumn(String column) {//finish??
    String rv = "column";
    columns.add(new Column(column));
    return rv;
  }
  public void addColumn(Column column) {
    columns.add(column);
  }

  public boolean removeColumn(String column) {
    for (Column c : columns) {
      if (c.getName().equals(column));
      {
        return columns.remove(c);
      }
    }
    return false;
  }

  public String renameColumn(String column, String rename) {
    for (Column c : columns) {
      if (c.getName().equals(column)) {
        c.setName(rename);
      }
    }
    return "Column renamed";
  }

  public String moveTask(String taskColumn, String task, String destination) {
    Column destColumn = null;
    for (Column c : columns) {
      if (c.getName().equals(destination)) {
        destColumn = c;//here
      }
    }
    if (destColumn == null) {
      return "Destination column not found";
    }
    Task temp = null;
    boolean exists = false;
    for (Column c : columns) {
      if (c.getName().equals(taskColumn)) {
        exists = true;
        for (Task t : c.getTasks()) {
          if (t.getTitle().equals(task)) {
            temp = t;
            //and here
          }
        }
        c.getTasks().remove(temp);
        destColumn.addTask(temp);
      }
    }

    if (!(temp == null && exists)) {
      return "Task or Column not found";
    }
    return "Task moved to destination column";
  }

  public Column getColumn(String name){
    for(int i = 0; i < columns.size(); i++){
      if(columns.get(i).getName().toLowerCase().equals(name.toLowerCase())){
        return columns.get(i);
      }
    }
    return null;
  }

  public ArrayList<Column> getColumns() {
    return this.columns;
  }

  public String getName() {
    return this.name;
  }

  public User getMaster() {
    return this.scrumMaster;
  }

  public ArrayList<User> getDevelopers() {
    return this.developers;
  }

  
}
