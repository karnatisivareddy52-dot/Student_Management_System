package com.nt.mains;


import java.util.Scanner;

import com.nt.entity.Student;
import com.nt.service.StudentService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter id: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade(a|b|c|d ");
                    String grade = sc.nextLine();
              
                    service.addStudent(new Student(id, name,grade));
                }
                case 2 -> service.viewAllStudents();
                case 3 -> {
                	System.out.print("Enter id: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade(A|B|C|DS ");
                    String grade = sc.nextLine();
                    service.updateStudent(new Student(id, name,grade));
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    service.deleteStudent(id);
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
