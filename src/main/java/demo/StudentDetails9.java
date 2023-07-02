package demo;

import domain.Course;
import domain.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class StudentDetails9 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Criteria crt = ses.createCriteria(Student.class);
        List<Student> studentList = crt.list();
        for (Student s1 : studentList)
        {
            System.out.println("================================================");
            System.out.println("STUDENT NAME : "+s1.getStudentName());
            List<Course> courseList = s1.getCourseList();
            for (Course c1 : courseList)
            {
                System.out.println("COURSE NAME : "+c1.getCourseName());
            }
        }
        System.out.println("================================================");

    }
}
