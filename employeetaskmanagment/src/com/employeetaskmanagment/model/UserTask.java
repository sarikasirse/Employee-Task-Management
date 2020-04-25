package com.employeetaskmanagment.model;

import java.time.LocalDate;


public class UserTask {
	
	public static final int TASK_STATUS_ASSIGNED = 0;
	public static final int TASK_STATUS_PENDING = 1;
	public static final int TASK_STATUS_INPROGRESS = 2;
	public static final int TASK_STATUS_COMPLETED = 3;
	public static final int TASK_STATUS_BLOCKED = 4;

	private int task_id;
	private String task_name;
	private int task_status;
	private LocalDate start_Date;
	private LocalDate end_Date;
	
	public UserTask() {
		super();
	}

	public UserTask(int task_id, String task_name, int task_status, 
			        LocalDate start_Date, LocalDate end_Date) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.task_status = task_status;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getTask_status() {
		return task_status;
	}

	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}

	public LocalDate getStartDate() {
		return start_Date;
	}

	public void setStartDate(LocalDate startDate) {
		this.start_Date = startDate;
	}

	public LocalDate getEndDate() {
		return end_Date;
	}

	public void setEndDate(LocalDate endDate) {
		this.end_Date = endDate;
	}

	@Override
	public String toString() {
		return "UserTask [task_id=" + task_id + ", task_name=" + task_name + ", task_status=" + task_status
				+ ", startDate=" + start_Date + ", endDate=" + end_Date + "]";
	}
}
