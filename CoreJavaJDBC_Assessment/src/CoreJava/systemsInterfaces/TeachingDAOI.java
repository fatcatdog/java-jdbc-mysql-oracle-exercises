//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.systemsInterfaces;

import CoreJava.Model.Instructor;
import CoreJava.Model.Teaching;

import java.util.List;

public interface TeachingDAOI {
    int assignInstructorToCourse(int course_id, int instructor_id);
    List<Teaching> getIntructorsCourses();
}
