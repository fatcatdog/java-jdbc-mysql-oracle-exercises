//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.DAO;

import CoreJava.Model.Course;
import CoreJava.systemsInterfaces.CourseDAOI;
import CoreJava.utils.MySqlQueries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements CourseDAOI {

    @Override
    public List<Course> getAllCourses() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Course> courseList = new ArrayList<Course>();

        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.get_all_courses);
            result = stmt.executeQuery();

            while(result.next())
            {
                courseList.add(new Course(result.getInt(1), result.getString(2),result.getDouble(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courseList;
    }

    @Override
    public List<Course> getCourseByInstructor(int instructor_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Course> courseList = new ArrayList<Course>();


        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.get_course_by_instructor);
            stmt.setInt(1, instructor_id);
            result = stmt.executeQuery();

            while(result.next())
            {
                courseList.add(new Course(result.getInt(1), result.getString(2),result.getDouble(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return courseList;
    }
}
