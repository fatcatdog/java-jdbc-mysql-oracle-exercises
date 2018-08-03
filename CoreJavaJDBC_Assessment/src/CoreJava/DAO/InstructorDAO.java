//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.DAO;

import CoreJava.Model.Instructor;
import CoreJava.systemsInterfaces.InstructorDAOI;
import CoreJava.utils.MySqlQueries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO implements InstructorDAOI {


    @Override
    public List<Instructor> getAllInstructors() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<Instructor> instructorList = new ArrayList<Instructor>();

        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.get_all_instructors);
            result = stmt.executeQuery();

            while(result.next())
            {
                instructorList.add(new Instructor(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6)));

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return instructorList;
    }


    @Override
    public Instructor getInstructoByGmail(String email) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Instructor i = null;


        try {
            conn = MySqlConnection.getConnection();
            stmt = conn.prepareStatement(MySqlQueries.get_instructor_by_gmail);
            stmt.setString(1, email);
            result = stmt.executeQuery();

            if(result.next())
            {
                i = new Instructor(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6));

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public String validateUser(Instructor ins, String comparablePas) {
        {
            if(! ins.getPass().equals(comparablePas))
                return "Wrong Credentials";
            else
            {
                if(ins.getAdmin_role() == 1)
                    return "Admin";
                else
                    return "Instructor";
            }
        }
    }
}
