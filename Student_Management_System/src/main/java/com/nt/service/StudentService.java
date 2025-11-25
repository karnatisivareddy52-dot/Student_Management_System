package com.nt.service;

import java.util.List;

import com.nt.dao.StudentDao;
import com.nt.entity.Student;

public class StudentService {
    private final StudentDao dao = new StudentDao();

    public void addStudent(Student student)
    {
        if (dao.addStudent(student)) 
        {
            System.out.println("Student added successfully!");
        }
        else 
        {
            System.out.println("Failed to add student.");
        }
    }
    
    public void viewAllStudents() {
        List<Student> list = dao.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            list.forEach(System.out::println);
        }
    }

    public void updateStudent(Student student) {
        if (dao.updateStudent(student)) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Update failed.");
        }
    }

    public void deleteStudent(int id) {
        if (dao.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Delete failed.");
        }
    }
}