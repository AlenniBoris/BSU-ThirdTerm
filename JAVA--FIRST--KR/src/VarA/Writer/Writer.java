package VarA.Writer;

import VarA.University.Course;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    static public void toFile(Course course, File file, boolean append)
    {
        try(FileWriter out = new FileWriter(file,append)) {
            out.write(course.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}