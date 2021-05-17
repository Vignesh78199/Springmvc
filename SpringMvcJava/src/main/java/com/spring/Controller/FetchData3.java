package com.spring.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.spring.Model.UserFriend3;

public class FetchData3 {
	
	public static ArrayList<UserFriend3> getMyFriend(HttpServletRequest request) throws ClassNotFoundException
	{
		ArrayList<UserFriend3> userfriendList=new ArrayList<UserFriend3>();
		ArrayList<String> statusList=new ArrayList<String>();
		String users = null,email=null;
		
	Cookie[] cookies=request.getCookies();

	for(Cookie temp:cookies)
	{
		if("email".equals(temp.getName()))
		{
			email=temp.getValue();
		}
	}
	for(Cookie temp1:cookies)
	{
		if("userid".equals(temp1.getName()))
		{
			users=temp1.getValue();
		}
	}
	
	int user =Integer.parseInt(users);
	
	try {
    	Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");	

        String queryString = "Select DISTINCT r.username,r.email from registratiion1 r inner join friends f on r.userid=f.userid where f.friendid=(select r.userid from registratiion1 r where r.email=? and status='2') union Select DISTINCT r.username,r.email from registratiion1 r inner join friends f on r.userid=f.friendid where f.userid=(select r.userid from registratiion1 r where r.email=? and status='2'and status!='0')";
        PreparedStatement ps=conn.prepareStatement(queryString);
        ps.setString(1,email);
        ps.setString(2,email);
        
        ResultSet result = ps.executeQuery();
    
        while(result.next()) {
        	
        		UserFriend3 userfriend= new UserFriend3();
        	
        	  
        		userfriend.setUsername(result.getString("username"));
        		userfriend.setEmail(result.getString("email"));
        		
        		userfriendList.add(userfriend);
        		String status="200";
        		String message="Success";
        		statusList.add(status);
        		statusList.add(message);
        }
        

    } catch (SQLException sql) {
    		
    	sql.printStackTrace();
    
    }
	return userfriendList;
	
	}

}


