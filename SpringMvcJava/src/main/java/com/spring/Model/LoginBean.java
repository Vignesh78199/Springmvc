package com.spring.Model;


public class LoginBean {
	
	
	private String email;
	private int userid;
	private String password;
	private String username;

	public String getPassword()
	{
			return this.password;
	}
	
	public String getEmail()
	{
			return this.email;
	}

	public void setEmail(String email)
	{
			this.email = email;
	}

	public void setPassword(String password)
	{
			this.password = password;
	}
	public int getUserid()
	{
			return this.userid;
	}

	public void setUserid(int userid)
	{
			this.userid = userid;
	}
	public String getUsername()
	{
			return this.username;
	}

	public void setUsername(String username)
	{
			this.username = username;
	}


}
