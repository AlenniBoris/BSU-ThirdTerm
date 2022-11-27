package Lab12.task1.StructClasses.Project;

import Lab12.task1.Interfaces.Visitor.Developer;
import Lab12.task1.Interfaces.Visitor.ProjectElement;

public class Database implements ProjectElement {
    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }
}
