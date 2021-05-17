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

public class FetchData2 {
	
	public static ArrayList<UserFriend3> getRequest(HttpServletRequest request) throws ClassNotFoundException
	{
		ArrayList<UserFriend3> userfriendList=new ArrayList<UserFriend3>();
		String users = null;
		
	Cookie[] cookies=request.getCookies();
	
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
		 String queryString = "select Distinct r.userid,username,email from registratiion1 r,friends f where f.friendid=? and status='1' and f.userid=r.userid";
	        PreparedStatement ps=conn.prepareStatement(queryString);
	        ps.setInt(1,user);
	        
	        
	        ResultSet result = ps.executeQuery();
    
        while(result.next()) {
        	
        		UserFriend3 userfriend= new UserFriend3();
        	
        		int userid1=result.getInt("r.userid");
        		userfriend.setUserid(String.valueOf(userid1));  
        		userfriend.setUsername(result.getString("username"));
        		userfriend.setEmail(result.getString("email"));
        		
        		userfriendList.add(userfriend);
        }
        

    } catch (SQLException sql) {
    		
    	sql.printStackTrace();
    
    }
	return userfriendList;
	
	}

}


