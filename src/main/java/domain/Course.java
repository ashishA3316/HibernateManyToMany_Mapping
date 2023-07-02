package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseID;
    @Column(name = "course_name")
    private String courseName;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_ref"),
            inverseJoinColumns = @JoinColumn(name = "student_ref")
    )
    private List<Student> studentList;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public void addStudent(Student student)
    {
        if(studentList==null)
        {
            studentList = new LinkedList<>();
        }
        studentList.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
