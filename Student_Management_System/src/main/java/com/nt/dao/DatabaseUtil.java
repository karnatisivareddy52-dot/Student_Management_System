package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil
{
    //private static final String URL = "jdbc:mysql://localhost:3306/srinudb";
	private static final String URL = "jdbc:mysql://localhost:3306/srinudb?useSSL=false&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "Srini@123";

    public static Connection getConnection()
    {
        try 
        {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        catch (SQLException e) 
        {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
