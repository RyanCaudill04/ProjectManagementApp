package javaFiles;

/**
 * a list of projects
 * @author Tristan
 */
import java.util.ArrayList;

public class ProjectList {
    private ArrayList<Project> projects;
    private static ProjectList projectList;

    private ProjectList() {
        projects = DataLoader.getProjects();
    }

    public static ProjectList getInstance() {
        if (projectList == null) {
            projectList = new ProjectList();
        }
        return projectList;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public Project addProject(String name, User scrumMaster, ArrayList<Column> columns, ArrayList<User> devs) {
        if (name == null || scrumMaster == null || devs == null) {
            return null;
        }
        if (columns == null) {
            columns = new ArrayList<Column>();
        }
        Project newProject = new Project(columns, name, scrumMaster, devs);
        projects.add(newProject);
        return newProject;
    }

    public boolean addProject(Project project) {
        if (project == null) {
            return false;
        }
        return projects.add(project);
    }

    public Project getProject(String name) {
        for (int i = 0; i < projects.size(); i++) {
            if (name.equals(projects.get(i).getName())) {
                return projects.get(i);
            }
        }
        return null;
    }

    public void saveProjects() {
        DataWriter.saveProjects();
    }
}
