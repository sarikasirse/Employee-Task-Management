package com.employeetaskmanagment.view;

import java.time.LocalDate;
import com.employeetaskmanagment.dao.EmployeeTaskManagementDAO;
import com.employeetaskmanagment.model.UserInfo;
import com.employeetaskmanagment.model.UserTask;

public class EmployeeTaskView {

	public static void main(String[] args) {
		EmployeeTaskManagementDAO employeeTaskManagementDAO = new EmployeeTaskManagementDAO();
		UserInfo userInfo = new UserInfo("Abhishek", "123", "abhshek@gmail.com");
		//userInfo.setId(5);
		employeeTaskManagementDAO.userInserted(userInfo);
		System.out.println(userInfo);
		
		UserInfo userInfo2 = new UserInfo("Aditi","235","aditi@gmail.com");
		userInfo2.setId(7);
		employeeTaskManagementDAO.userInserted(userInfo2);
		System.out.println(employeeTaskManagementDAO.deleteUser(userInfo2));
				
		UserTask userTask = new UserTask();
		userTask.setTask_id(1);
		userTask.setTask_name("Implement Java Code");
		LocalDate startDate = LocalDate.of(2020, 04, 03);
		userTask.setStartDate(startDate);
		
		LocalDate endDate = LocalDate.of(2020, 04, 25);
		userTask.setEndDate(endDate);
		
		userTask.setTask_status(UserTask.TASK_STATUS_INPROGRESS);
		System.out.println("Display Employees Task : "+userTask);
		System.out.println(employeeTaskManagementDAO.assignTask(userInfo, userTask));
		
		LocalDate todayDate = LocalDate.now();
		if(endDate.equals(todayDate)) {
			System.out.println("Alert employees task end date:" +todayDate);
		}else {
			System.out.println("continue on given task");
		}
		
		LocalDate yesterDate = endDate.minusDays(1);
		if(yesterDate.isBefore(endDate)) {
			System.out.println("Last day of complete the task:" +endDate);
		}else {
			System.out.println("continue on your work");
		}			
	}
}
