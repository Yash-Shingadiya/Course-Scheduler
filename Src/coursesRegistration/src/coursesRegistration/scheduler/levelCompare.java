package coursesRegistration.scheduler;

import java.util.Comparator;

/**
 * Class that is used for sorting the studentLists(Arraylist of Students) on the basis of studentLevel
 */
public class levelCompare implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        return s1.getStudentLevel().compareTo(s2.getStudentLevel());
    }
}
