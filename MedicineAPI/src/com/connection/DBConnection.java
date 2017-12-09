package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		
	public static Connection getConnection() throws SQLException, Exception
    {
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicine","root","root");
        }
        catch(SQLException e)
        {
        	throw e;
        }
        catch(Exception e)
        {
            throw e;
        }
        return conn;
    }

}