package com.employeetaskmanagment.model;

public class UserTaskAssigment {
	private UserInfo userInfo;
	private UserTask userTask;
	
	public UserTaskAssigment(UserInfo userInfo, UserTask userTask) {
		super();
		this.userInfo = userInfo;
		this.userTask = userTask;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserTask getUserTask() {
		return userTask;
	}

	public void setUserTask(UserTask userTask) {
		this.userTask = userTask;
	}

}
