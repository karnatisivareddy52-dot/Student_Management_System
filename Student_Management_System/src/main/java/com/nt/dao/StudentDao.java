package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nt.entity.Student;

public class StudentDao {

    public boolean addStudent(Student student)
    {
        String sql = "INSERT INTO Student(id,name,grade) VALUES (?, ?,?)";
        try (
        	Connection conn = DatabaseUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
               {
                   ps.setInt(1, student.getId());
                   ps.setString(2, student.getName());
                   ps.setString(3, student.getGrade());
                      return ps.executeUpdate() > 0;
                } 
        catch (SQLException e) 
        {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    
}

	public List<Student> getAllStudents()
	{
		List<Student> list = new ArrayList<Student>();
        String sqls = "SELECT * FROM Student";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sqls))
        {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("grade")));
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
        
        return list; 
	}

	public boolean updateStudent(Student student) 
	{
		String sql = "UPDATE student SET name=?, grade=? WHERE id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getGrade());
            ps.setInt(3,student.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
	}

	public boolean deleteStudent(int id)
	{
		String sql = "DELETE FROM student WHERE id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
	}


}