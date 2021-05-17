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
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Model.UserFriend;
import com.spring.Model.UserFriend2;

@RestController
public class RestCall {
	
	@RequestMapping("/Restcall")
	public  ModelAndView RestCall(String user,String email,String place,String username,String age1,HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException 
	{
		ModelAndView mv=new ModelAndView();
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
		for(Cookie temp1:cookies)
		{
			if("userid".equals(temp1.getName()))
			{
				user=temp1.getValue();
			}
		}
		int user1=Integer.parseInt(user);
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
	        ArrayList<String> suggestList = new ArrayList<String>();
	        ArrayList<UserFriend> std = new ArrayList<UserFriend>();
	        while(result.next()) {
	        		int userid1=result.getInt("r.userid");
	        		String userid=String.valueOf(userid1);  
	        		String name=result.getString("username");
	        		String mail=result.getString("email");
	        		List<String> namesList = Arrays.asList(userid, mail,name);
	        			suggestList.addAll(namesList);   
	        		std.add(new UserFriend(userid,mail,name));
	        }
	        request.setAttribute("data", std);
	    	mv.addObject("friend_name",suggestList);
	    	String queryString1 = "select Distinct r.userid,username,email from registratiion1 r,friends f where f.friendid=? and status='1' and f.userid=r.userid";
	        PreparedStatement ps1=conn.prepareStatement(queryString1);
	        ps1.setInt(1,user1);
	        
	        
	        ResultSet result1 = ps1.executeQuery();
	        
	        ArrayList<String> requestList = new ArrayList<String>();
	        ArrayList<UserFriend> std1 = new ArrayList<UserFriend>();
	        while(result1.next()) {
	        		int id1=result1.getInt("r.userid");
	        		String id=String.valueOf(id1);
	        		String name=result1.getString("username");
	        		String mail=result1.getString("email");
	        		List<String> namesList = Arrays.asList(id, mail,name);
	        			requestList.addAll(namesList);   
	        		std1.add(new UserFriend(id,mail,name));
	        	  	 
	        	
	        	
	        
	        }
	        request.setAttribute("data", std1);
	    	mv.addObject("friend_name",requestList);
	    	 String queryString11 = "Select DISTINCT r.username,r.userid from registratiion1 r inner join friends f on r.userid=f.userid where f.friendid=(select r.userid from registratiion1 r where r.email=? and status='2') union  Select DISTINCT username,r.userid from registratiion1 r inner join friends f on r.userid=f.friendid where f.userid=(select r.userid from registratiion1 r where r.email=? and status='2'and status!='0')";
		        PreparedStatement ps11=conn.prepareStatement(queryString11);
		        ps11.setString(1,email);
		        ps11.setString(2,email);
		        
		        ResultSet result11 = ps11.executeQuery();
		        
		        ArrayList<String> friendList = new ArrayList<String>();
		        ArrayList<UserFriend2> std11 = new ArrayList<UserFriend2>();
		        while(result11.next()) {
		      
		        		String name=result11.getString("username");
		        		int friend=result11.getInt("userid");
		        		String userid=String.valueOf(friend);  
		        
		        		List<String> namesList = Arrays.asList( name,userid);
		        			friendList.addAll(namesList);   
		        		std11.add(new UserFriend2(name,userid));
		        	  	 
		        	
		        	
		        
		        }
		        request.setAttribute("data", std11);
		    	mv.addObject("friend_name",friendList);
		
		}
		catch (SQLException sql) {

		    
	    }
		
		
		
		
		mv.setViewName("restcall.jsp");
		return mv;
		
	}
	
}
