package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentID;
    @Column(name = "student_name")
    private String studentName;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_ref"),
            inverseJoinColumns = @JoinColumn(name = "course_ref")
    )
    private List<Course> courseList;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(Course course)
    {
        if(courseList==null)
        {
            courseList=new LinkedList<>();
        }
        courseList.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
