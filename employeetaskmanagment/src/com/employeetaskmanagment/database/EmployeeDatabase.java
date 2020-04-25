package com.employeetaskmanagment.database;

import java.sql.*;
public class EmployeeDatabase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Connection conn = null;
			Statement stmt = null;
			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:employee_task_management.db");
				System.out.println("database created successfully");

				stmt = conn.createStatement();

				String createUserInfoTable = "CREATE TABLE IF NOT EXISTS UserInfo " + "(id INTEGER PRIMARY KEY autoincrement,"
						+ " username CHAR(50)  NOT NULL, " + " password CHAR(10)  NOT NULL, " + " email CHAR(50)  NOT NULL)";
				stmt.executeUpdate(createUserInfoTable);
				
				String createUserTaskTable = "CREATE TABLE IF NOT EXISTS UserTask " + "(task_id INTEGER PRIMARY KEY autoincrement,"
						+ "task_name CHAR(50) NOT NULL, " + " start_date datetime NOT NULL,"+" end_date datetime NOT NULL, " + " task_status INTEGER  NOT NULL)";
				stmt.executeUpdate(createUserTaskTable);
				
				String createTaskAssignmentTable = "CREATE TABLE IF NOT EXISTS tasks_assignment " + "(user_id INTEGER NOT NULL,"
						+ "task_id INTEGER NOT NULL," + "foreign key (user_id) references users(id),"
						+ " foreign key (task_id) references tasks(task_id)) ";
				stmt.executeUpdate(createTaskAssignmentTable);
				
				stmt.close();
				conn.close();

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Tables created successfully");
		}
        public static Connection getConnection() {
        	Connection conn = null;
        	try {
        		Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:employee_task_management.db");
        	    
        	}catch (Exception e) {
				// TODO: handle exception
        		e.printStackTrace();
			}
        	return conn;
        }
	}
