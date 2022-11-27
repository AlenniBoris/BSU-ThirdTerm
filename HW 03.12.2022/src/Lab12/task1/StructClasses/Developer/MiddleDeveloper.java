package Lab12.task1.StructClasses.Developer;

import Lab12.task1.Interfaces.Visitor.Developer;
import Lab12.task1.StructClasses.Project.Database;
import Lab12.task1.StructClasses.Project.SimpleNetwork;
import Lab12.task1.StructClasses.Project.Website;

public class MiddleDeveloper implements Developer {
    @Override
    public void create(Database database) {
        System.out.println("Middle can write simple databases");
    }

    @Override
    public void create(SimpleNetwork simpleNetwork) {
        System.out.println("Middle can write simple networks");
    }

    @Override
    public void create(Website website) {
        System.out.println("Middle can write websites using JavaScript");
    }
}
