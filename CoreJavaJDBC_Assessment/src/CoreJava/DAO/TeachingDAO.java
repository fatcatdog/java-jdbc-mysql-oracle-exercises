//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.DAO;

import CoreJava.Model.Teaching;
import CoreJava.systemsInterfaces.TeachingDAOI;
import CoreJava.utils.MySqlQueries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeachingDAO implements TeachingDAOI {

    @Override
    public int assignInstructorToCourse(int course_id, int instructor_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;

        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.register_instructor_to_course);
            stmt.setInt(1, course_id);
            stmt.setInt(2, instructor_id);
            result = stmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Teaching> getIntructorsCourses() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Teaching> teachingList = new ArrayList<Teaching>();

        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.get_instructor_courses);
            result = stmt.executeQuery();

            while(result.next())
            {
                teachingList.add(new Teaching(result.getString(1),result.getDouble(2),result.getString(3),result.getString(4)));

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return teachingList;
    }
}
