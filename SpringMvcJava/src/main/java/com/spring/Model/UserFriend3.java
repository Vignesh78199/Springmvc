package com.spring.Model;

public class UserFriend3 {
	

public UserFriend3(String email,String username,String userid )
{
	this.setUserid(userid);
	this.setEmail(email);
	this.setUsername(username);
	
	
}
public UserFriend3()
{
	
}
	
	private String email;
	private String username;
	
	private String userid;

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	

}
