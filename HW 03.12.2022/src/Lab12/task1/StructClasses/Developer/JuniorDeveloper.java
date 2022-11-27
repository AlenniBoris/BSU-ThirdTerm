package Lab12.task1.StructClasses.Developer;

import Lab12.task1.Interfaces.Visitor.Developer;
import Lab12.task1.StructClasses.Project.Database;
import Lab12.task1.StructClasses.Project.SimpleNetwork;
import Lab12.task1.StructClasses.Project.Website;

public class JuniorDeveloper implements Developer {
    @Override
    public void create(Database database) {
        System.out.println("Junior knows database basics");
    }

    @Override
    public void create(SimpleNetwork simpleNetwork) {
        System.out.println("Junior can't make networks");
    }

    @Override
    public void create(Website website) {
        System.out.println("Junior knows only CSS and HTML");
    }
}
