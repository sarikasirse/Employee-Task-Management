package com.employeetaskmanagment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.employeetaskmanagment.database.EmployeeDatabase;
import com.employeetaskmanagment.model.UserInfo;
import com.employeetaskmanagment.model.UserTask;

public class EmployeeTaskManagementDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String sql;
	private ResultSet resultSet;
	
	public boolean userInserted(UserInfo userInfo) {
		boolean isInserted = false;
		
		sql = "INSERT INTO userInfo(username, password, email) VALUES (?, ?, ?)";
		
		try {
			connection = EmployeeDatabase.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, userInfo.getUsername());
			preparedStatement.setString(2, userInfo.getPassword());
			preparedStatement.setString(3, userInfo.getEmail());

			int rowsInserted = preparedStatement.executeUpdate();

			if (rowsInserted > 0) {
				isInserted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isInserted;
	}
	
	public UserInfo getUser(int id) {
		UserInfo userInfo = null;
		
		sql = "SELECT * FROM userInfo WHERE id = ?";
		
		try {
			connection = EmployeeDatabase.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userInfo;
	}
	
	public ArrayList<UserInfo> getAllUsers(){
		ArrayList<UserInfo> arrayList = new ArrayList<UserInfo>();
		
		sql = "SELECT * FROM userInfo";
		
		try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			UserInfo userInfo = new UserInfo();
			userInfo.setId(resultSet.getInt(1));
			userInfo.setUsername(resultSet.getString(2));
			userInfo.setPassword(resultSet.getString(3));
			userInfo.setEmail(resultSet.getString(4));
			
			arrayList.add(userInfo);
		}
	  } catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return arrayList;
	}

	public boolean updateUser(UserInfo userInfo) {

	boolean isUpdated = false;

	sql = "UPDATE userInfo SET username = ?, password = ?,  email = ? WHERE id = ?";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, userInfo.getUsername());
		preparedStatement.setString(2, userInfo.getPassword());
		preparedStatement.setString(3, userInfo.getEmail());
		preparedStatement.setInt(4, userInfo.getId());

		int rowsUpdated = preparedStatement.executeUpdate();

		if (rowsUpdated > 0) {
			isUpdated = true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return isUpdated;
	}

	public boolean deleteUser(UserInfo userInfo) {
	boolean isDeleted = false;

	sql = "DELETE FROM userInfo WHERE id = ?";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, userInfo.getId());

		int rowsDeleted = preparedStatement.executeUpdate();

		if (rowsDeleted > 0) {
			isDeleted = true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return isDeleted;
}
// Task Data

	public boolean insertTask(UserTask userTask) {
	boolean isInserted = false;

	sql = "INSERT INTO userTask (task_name, task_status, start_date, end_date) VALUES (?, ?, ?,?)";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, userTask.getTask_name());
		//preparedStatement.setDate(2,userTask.getStartDate());
		//preparedStatement.setDate(3,userTask.getEndDate());
		preparedStatement.setInt(4, UserTask.TASK_STATUS_ASSIGNED);

		int rowsInserted = preparedStatement.executeUpdate();

		if (rowsInserted > 0) {
			isInserted = true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return isInserted;
}

	public boolean updateTask(UserTask userTask) {

	boolean isUpdated = false;

	sql = "UPDATE userTask SET task_name = ?, task_status = ?, start_date = ?, end_date = ? WHERE id = ?";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, userTask.getTask_name());
		//preparedStatement.setDate(2,userTask.getStartDate());
		//preparedStatement.setDate(3,userTask.getEndDate());
		preparedStatement.setInt(4, userTask.getTask_status());
		preparedStatement.setInt(5, userTask.getTask_id());

		int rowsUpdated = preparedStatement.executeUpdate();

		if (rowsUpdated > 0) {
			isUpdated = true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return isUpdated;
}

	public boolean deleteTask(UserTask userTask) {
	boolean isDeleted = false;

	sql = "DELETE FROM userTask WHERE id = ?";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, userTask.getTask_id());

		int rowsDeleted = preparedStatement.executeUpdate();

		if (rowsDeleted > 0) {
			isDeleted = true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return isDeleted;
}

	public UserTask getTask(int id) {
	UserTask userTask = null;

	sql = "SELECT * FROM userTask WHERE id = ?";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, id);

		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			userTask = new UserTask();
			userTask.setTask_id(resultSet.getInt(1));
			userTask.setTask_name(resultSet.getString(2));
			//userTask.setStartDate(resultSet.getDate(3));
			//userTask.setEndDate(resultSet.getDate(4));
			userTask.setTask_status(resultSet.getInt(5));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return userTask;
}

public ArrayList<UserTask> getAllTasks() {
	ArrayList<UserTask> userTask = new ArrayList<>();

	sql = "SELECT * FROM userTask";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);

		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			UserTask task= new UserTask();
		
			task.setTask_id(resultSet.getInt(1));
			task.setTask_name(resultSet.getString(2));
			task.setTask_status(resultSet.getInt(3));
			//task.setStartDate(resultSet.getDate(4));
			//task.setEndDate(resultSet.getDate(5));
		
			userTask.add(task);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return userTask;
}
public boolean assignTask(UserInfo userInfo, UserTask userTask) {
	boolean isAssigned = false;

	sql = "INSERT INTO tasks_assignment (user_id, task_id) VALUES (?, ?)";

	try {
		connection = EmployeeDatabase.getConnection();
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, userInfo.getId());
		preparedStatement.setInt(2, userTask.getTask_id());

		int rowsAssigned = preparedStatement.executeUpdate();

		if (rowsAssigned > 0) {
			isAssigned = true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	return isAssigned;
	}
}






