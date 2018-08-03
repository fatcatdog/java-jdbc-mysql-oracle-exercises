//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.systemsInterfaces;

import CoreJava.Model.Student;

public interface StudentDAOI {

    Student getStudentByGmail(String email);
    boolean validateUser(String passToValidate, String comparablePas);
}
