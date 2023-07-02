package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class StudentDetails7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID");
        int id = sc.nextInt();

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

        Student s1 = ses.get(Student.class, id);
        if(s1!=null)
        {
            System.out.println("NAME : "+s1.getStudentName());
            List<Course> courseList = s1.getCourseList();
            for (Course c : courseList)
            {
                System.out.println(c.getCourseName());
            }
        }
        else
        {
            System.out.println("INVALID STUDENT ID");
        }

    }
}
