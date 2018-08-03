//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.systemsInterfaces;

import CoreJava.Model.Attending;
import CoreJava.Model.Course;
import CoreJava.Model.Student;

import java.util.List;

public interface AttendingDAOI {
    int registerStudentToCourse(Student student, Course course);
    List<Attending> getStudentCourse(int student_id);

}
