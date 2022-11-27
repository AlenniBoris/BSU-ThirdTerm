package Lab12.task1.StructClasses.Project;

import Lab12.task1.Interfaces.Iterator.Iterator;
import Lab12.task1.Interfaces.Visitor.Developer;
import Lab12.task1.Interfaces.Visitor.ProjectElement;
import Lab12.task1.StructClasses.Multitude.Multitude;

public class Project implements ProjectElement {
    private final Multitude<ProjectElement> projects;

    public Project(Multitude<ProjectElement> projects) {
        this.projects = projects;
    }

    public Project() {
        projects = new Multitude<>();
        projects.add(new Database());
        projects.add(new SimpleNetwork());
        projects.add(new Website());
    }

    @Override
    public void beWritten(Developer developer) {
        for(ProjectElement element : projects.getArrayList()){
            element.beWritten(developer);
        }
    }
}
