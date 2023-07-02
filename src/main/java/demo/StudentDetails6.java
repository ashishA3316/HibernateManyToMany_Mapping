package demo;

import domain.Course;
import domain.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentDetails6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;


        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        System.out.println("Enter the Student Name");
        String name=sc.next();

        int Count=1;
        Criteria crt1= ses.createCriteria(Course.class);
        System.out.println("Select Course");
        List<Course> List=crt1.list();
        for (Course p:List) {
            System.out.println( Count +" " +p.getCourseName());
            Count++;
        }

        List<Integer> recordIds = new LinkedList<>();

        sc.nextLine();
        String input = sc.nextLine();
        String[] idStrings = input.split(",");
        for (String idString : idStrings) {
            try {
                int id = Integer.parseInt(idString.trim());

                if (id > 0 && id <= Count) {
                    recordIds.add(id);
                } else {
                    System.out.println("Invalid ID: " + id);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + idString);
            }
        }
        Student s2=new Student();
        for(int i=0;i< recordIds.size();i++)
        {
            Course c2=ses.get( Course.class,recordIds.get(i));
            s2.addCourse(c2);
        }

        s2.setStudentName(name);


        tx=ses.beginTransaction();
        ses.save(s2);
        tx.commit();
        System.out.println("insert Record");
    }
}
