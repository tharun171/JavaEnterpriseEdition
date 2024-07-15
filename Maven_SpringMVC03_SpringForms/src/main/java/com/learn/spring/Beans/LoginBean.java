package com.learn.spring.Beans;

public class LoginBean {

	private String userName;
	private String password;
	
	public LoginBean()
	{
		System.out.println("bean initaited.....");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "loginBean [userName=" + userName + ", password=" + password + "]";
	}
}
