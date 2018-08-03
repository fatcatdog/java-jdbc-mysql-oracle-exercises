//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.DAO;

import CoreJava.CustomExceptions.StudentRegistrationException;
import CoreJava.Model.Attending;
import CoreJava.Model.Course;
import CoreJava.Model.Student;
import CoreJava.systemsInterfaces.AttendingDAOI;
import CoreJava.utils.MySqlQueries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendingDAO implements AttendingDAOI {

    @Override
    public int registerStudentToCourse(Student student, Course course) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        String[] Col = {"GPA"};


        try {
            if(student.getGpa() < course.getMinimum_gpa())
                throw new StudentRegistrationException("Did not meet the minimum GPA requirement");
            else
            {
                conn = MySqlConnection.getConnection();
                stmt = conn.prepareStatement(MySqlQueries.register_student_in_course);
                stmt.setInt(1, course.getCourse_id());
                stmt.setInt(2, student.getStudent_id());
                result = stmt.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public List<Attending> getStudentCourse(int student_id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Attending> attendingList = new ArrayList<Attending>();

        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.get_student_course);
            stmt.setInt(1, student_id);
            result = stmt.executeQuery();
            while(result.next())
            {
                attendingList.add(new Attending(result.getString(1),result.getString(2),result.getString(3)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return attendingList;
    }
}
