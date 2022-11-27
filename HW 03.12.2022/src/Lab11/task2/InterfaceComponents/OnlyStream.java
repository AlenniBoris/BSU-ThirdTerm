package Lab11.task2.InterfaceComponents;

import Lab11.task2.Interface.*;
import Lab11.task2.Student.*;

import java.util.ArrayList;
import java.util.Comparator;

public class OnlyStream implements Strategy {
    private ArrayList<Student> elements;

    public OnlyStream(ArrayList<Student> elements) {
        this.elements = elements;
    }

    @Override
    public String[] getResult() {
        return elements.stream().map(Student::getSubject).distinct().sorted(Comparator.naturalOrder()).toArray(String[]::new);
    }
}
