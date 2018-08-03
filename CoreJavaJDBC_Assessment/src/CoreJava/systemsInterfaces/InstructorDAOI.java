//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.systemsInterfaces;

import CoreJava.Model.Instructor;

import java.util.List;

public interface InstructorDAOI {
    List<Instructor> getAllInstructors();
    Instructor getInstructoByGmail(String email);
    String validateUser(Instructor ins, String comparablePas);

}
