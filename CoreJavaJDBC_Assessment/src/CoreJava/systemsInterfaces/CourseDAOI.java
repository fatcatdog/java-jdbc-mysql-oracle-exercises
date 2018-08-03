//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.systemsInterfaces;

import CoreJava.Model.Course;

import java.util.List;

public interface CourseDAOI {
    List<Course> getAllCourses();
    List<Course> getCourseByInstructor(int instructor_id);
}
