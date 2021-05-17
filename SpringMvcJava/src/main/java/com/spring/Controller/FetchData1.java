package com.spring.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.spring.Model.UserFriend;
import com.spring.Model.UserFriend3;

public class FetchData1 {
	
	public static ArrayList<UserFriend3> getSuggestion(HttpServletRequest request) throws ClassNotFoundException
	{
		ArrayList<UserFriend3> userfriendList=new ArrayList<UserFriend3>();
		String email,place = null,username = null,userid,age1 = null;
		
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
		if("place".equals(temp1.getName()))
		{
			place=temp1.getValue();
		}
	}
	for(Cookie temp1:cookies)
	{
		if("username".equals(temp1.getName()))
		{
			username=temp1.getValue();
		}
	}
	for(Cookie temp1:cookies)
	{
		if("age".equals(temp1.getName()))
		{
			age1=temp1.getValue();
		}
	}
	int age =Integer.parseInt(age1);
	
	try {
    	Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");	
        String queryString = "select DISTINCT r.userid,r.email,r.username from registratiion1 r,friends f where r.username IN(select DISTINCT r.username from registratiion1 where place=? ) and r.username NOT IN (Select DISTINCT username from registratiion1 r inner join friends f on r.userid=f.userid where f.friendid=(select r.userid from registratiion1 r where r.username=?) union all Select DISTINCT username from registratiion1 r inner join friends f on r.userid=f.friendid where f.userid=(select r.userid from registratiion1 r where r.username=?))and r.username!=? and place=? and status!='2' and status!=1 and age>?-5"; 	
        PreparedStatement ps=conn.prepareStatement(queryString);
        ps.setString(1,place);
        ps.setString(2,username);
        ps.setString(3,username);
        ps.setString(4,username);
        ps.setString(5,place);
        ps.setInt(6, age);
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
