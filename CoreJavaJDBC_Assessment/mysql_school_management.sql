CREATE TABLE student(
student_id INT NOT NULL UNIQUE AUTO_INCREMENT,
full_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
gpa DECIMAL(5,2) NOT NULL,
pass VARCHAR(255) NOT NULL,
student_role NUMERIC(38,0) NOT NULL,
PRIMARY KEY (student_id)
);

INSERT INTO STUDENT(full_name, email, gpa, pass, student_role) VALUES('Bairon Vasquez','b@gmail.com', 3.4, '111', -1);
INSERT INTO STUDENT(full_name, email, gpa, pass, student_role) VALUES('Yamil Burgos','y@gmail.com', 3.4, '222', -1);
INSERT INTO STUDENT(full_name, email, gpa, pass, student_role) VALUES('Joseph Robinson','J@gmail.com', 3.9, '333', -1);


CREATE TABLE instructor(
instructor_id INT NOT NULL UNIQUE AUTO_INCREMENT,
full_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
speciality VARCHAR(255) NOT NULL,
admin_role NUMERIC(38,0) NOT NULL,
pass VARCHAR(255) NOT NULL,
PRIMARY KEY (instructor_id)
);

INSERT INTO INSTRUCTOR(full_name, email, speciality, admin_role, pass) VALUES('Luke','luke@gmail.com', 'Mathemathician', 0, '444');
INSERT INTO INSTRUCTOR(full_name, email, speciality, admin_role, pass) VALUES('lance','lance@gmail.com', 'scientis', 0, '555');
INSERT INTO INSTRUCTOR(full_name, email, speciality, admin_role, pass) VALUES('mark','mark@gmail.com', 'important', 1, '666');

CREATE TABLE course(
course_id INT NOT NULL UNIQUE AUTO_INCREMENT,
course_name VARCHAR(255) NOT NULL UNIQUE,
minimun_gpa DECIMAL(5,2) NOT NULL,
PRIMARY KEY (course_id)
);
INSERT INTO COURSE(course_name, minimun_gpa) VALUES('Math', 3.1);
INSERT INTO COURSE(course_name, minimun_gpa) VALUES('Science', 3.2);
INSERT INTO COURSE(course_name, minimun_gpa) VALUES('English', 3.1);
INSERT INTO COURSE(course_name, minimun_gpa) VALUES('GYM', 2.8);

CREATE TABLE teaching(
teaching_id INT NOT NULL UNIQUE AUTO_INCREMENT,
course_id INT NOT NULL,
instructor_id INT NOT NULL,
FOREIGN KEY (course_id) REFERENCES course(course_id),
FOREIGN KEY (instructor_id) REFERENCES instructor(instructor_id),
PRIMARY KEY (teaching_id)
);

INSERT INTO TEACHING(course_id, instructor_id) VALUES(1,1);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(2,3);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(3,2);

CREATE TABLE attending(
attending_id INT NOT NULL UNIQUE AUTO_INCREMENT,
course_id INT NOT NULL,
student_id INT NOT NULL,
FOREIGN KEY(course_id) REFERENCES course(course_id),
FOREIGN KEY(student_id) REFERENCES student(student_id),
PRIMARY KEY (attending_id)
);

INSERT INTO ATTENDING(course_id, student_id) VALUES(1,3);
INSERT INTO ATTENDING(course_id, student_id) VALUES(2,3);


COMMIT;
