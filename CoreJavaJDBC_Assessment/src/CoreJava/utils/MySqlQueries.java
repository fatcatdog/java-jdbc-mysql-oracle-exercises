//@Author = Jacob Duchen
//@Date = 8/3/18

package CoreJava.utils;

public class MySqlQueries {

    public final static String get_student_by_gmail = "SELECT * FROM STUDENT " + "WHERE EMAIL = ? ORDER BY STUDENT_ID ASC";

    public final static String get_instructor_by_gmail = "SELECT * FROM INSTRUCTOR " + "WHERE EMAIL = ? ORDER BY INSTRUCTOR_ID ASC";

    public final static String get_all_instructors = "SELECT * FROM INSTRUCTOR " + "ORDER BY INSTRUCTOR_ID ASC";

    public final static String get_all_courses = "SELECT * FROM COURSE " + "ORDER BY COURSE_ID ASC";

    public final static String get_course_by_instructor = "SELECT COURSE.COURSE_ID, COURSE.COURSE_NAME, COURSE.MINIMUN_GPA " + "FROM COURSE JOIN TEACHING ON COURSE.COURSE_ID = TEACHING.COURSE_ID " + "WHERE INSTRUCTOR_ID = ? ORDER BY COURSE_ID ASC";

    public final static String register_student_in_course = "INSERT INTO ATTENDING(COURSE_ID,STUDENT_ID) " + "VALUES(?,?)";

    public final static String get_student_course = "SELECT COURSE.COURSE_NAME, STUDENT.FULL_NAME, STUDENT.EMAIL " + "FROM STUDENT JOIN ATTENDING ON ATTENDING.STUDENT_ID = STUDENT.STUDENT_ID " + "JOIN COURSE ON COURSE.COURSE_ID = ATTENDING.COURSE_ID " + "WHERE STUDENT.STUDENT_ID = ?";

    public final static String register_instructor_to_course = "INSERT INTO TEACHING(COURSE_ID, INSTRUCTOR_ID) " + "VALUES(?,?)";

    public final static String get_instructor_courses = "SELECT COURSE.COURSE_NAME,COURSE.MINIMUN_GPA, INSTRUCTOR.FULL_NAME, INSTRUCTOR.EMAIL " + "FROM INSTRUCTOR JOIN TEACHING ON TEACHING.INSTRUCTOR_ID = INSTRUCTOR.INSTRUCTOR_ID " + "JOIN COURSE ON COURSE.COURSE_ID = TEACHING.COURSE_ID ";

}
