package Lab12.task1.StructClasses.Developer;

import Lab12.task1.Interfaces.Visitor.Developer;
import Lab12.task1.StructClasses.Project.Database;
import Lab12.task1.StructClasses.Project.SimpleNetwork;
import Lab12.task1.StructClasses.Project.Website;

public class SeniorDeveloper implements Developer {
    @Override
    public void create(Database database) {
        System.out.println("Senior can write databases");
    }

    @Override
    public void create(SimpleNetwork simpleNetwork) {
        System.out.println("Senior can write such networks as Facebook");
    }

    @Override
    public void create(Website website) {
        System.out.println("Senior knows not only JS< but also different frameworks");
    }
}
