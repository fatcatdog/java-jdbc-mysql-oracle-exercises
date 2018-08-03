//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.Model;

public class Instructor {

    private int instructor_id;
    private String full_name;
    private String email;
    private String specialty;
    private int admin_role = 0;
    private String pass;

    public Instructor(int instructor_id, String full_name, String email, String specialty, int admin_role, String pass) {
        this.instructor_id = instructor_id;
        this.full_name = full_name;
        this.email = email;
        this.specialty = specialty;
        this.admin_role = admin_role;
        this.pass = pass;
    }

    public Instructor() {
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(int admin_role) {
        this.admin_role = admin_role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
