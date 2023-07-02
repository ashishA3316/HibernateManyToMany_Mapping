package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class StudentDetails8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Course ID");
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

        Course c1 = ses.get(Course.class, id);
        if(c1!=null)
        {
            System.out.println("NAME : "+c1.getCourseName());
            List<Student> studentList = c1.getStudentList();
            for (Student student : studentList)
            {
                System.out.println(student.getStudentName());
            }
        }
    }
}
