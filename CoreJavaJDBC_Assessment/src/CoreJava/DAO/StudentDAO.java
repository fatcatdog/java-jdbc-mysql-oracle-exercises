//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.DAO;

import CoreJava.Model.Student;
import CoreJava.systemsInterfaces.StudentDAOI;
import CoreJava.utils.MySqlQueries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO implements StudentDAOI {

    @Override
    public Student getStudentByGmail(String email) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Student student = null;

        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.get_student_by_gmail);
            stmt.setString(1, email);
            result = stmt.executeQuery();

            if(result.next())
            {
                student = new Student(result.getInt(1), result.getString(2),result.getString(3),result.getDouble(4),result.getString(5),result.getInt(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return student;
    }

    @Override
    public boolean validateUser(String passToValidate, String comparablePas){
        return passToValidate.equals(comparablePas);
    }

}
