package Lab12.task1.Interfaces.Visitor;

import Lab12.task1.StructClasses.Project.Database;
import Lab12.task1.StructClasses.Project.SimpleNetwork;
import Lab12.task1.StructClasses.Project.Website;

public interface Developer{
    abstract void create(Database database);
    abstract void create(SimpleNetwork simpleNetwork);
    abstract void create(Website website);
}
