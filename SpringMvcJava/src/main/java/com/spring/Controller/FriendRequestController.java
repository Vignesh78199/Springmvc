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

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Model.UserFriend;

@Controller

public class FriendRequestController {
	
	private final Logger logger=Logger.getLogger(FriendRequestController.class);
	
	@RequestMapping(value="/friendrequest" ,method=RequestMethod.GET)
	public  ModelAndView myfriend(String email,String user,HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException 
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
		Cookie[] cookies1=request.getCookies();
		for(Cookie temp:cookies1)
		{
			if("userid".equals(temp.getName()))
			{
				user=temp.getValue();
			}
		}
		int userid=Integer.parseInt(user);  
		
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			
	    
	        String queryString = "select Distinct r.userid,username,email from registratiion1 r,friends f where f.friendid=? and status='1' and f.userid=r.userid";
	        PreparedStatement ps=conn.prepareStatement(queryString);
	        ps.setInt(1,userid);
	        
	        
	        ResultSet result = ps.executeQuery();
	        
	        ArrayList<String> requestList = new ArrayList<String>();
	        ArrayList<UserFriend> std = new ArrayList<UserFriend>();
	        while(result.next()) {
	        		int id1=result.getInt("r.userid");
	        		String id=String.valueOf(id1);
	        		String name=result.getString("username");
	        		String mail=result.getString("email");
	        		List<String> namesList = Arrays.asList(id, mail,name);
	        			requestList.addAll(namesList);   
	        		std.add(new UserFriend(id,mail,name));
	        	  	 
	        	
	        	
	        
	        }
	        request.setAttribute("data", std);
	    	mv.addObject("friend_name",requestList);
    		 
	       
	    	  
	        logger.info("getting application context file...");
	        result.close();
	        ps.close();
	        conn.close();

	    } catch (SQLException sql) {

	    	
	    }
		
		
		
		
		
        
		
		
		
		
	mv.setViewName("FriendRequest.jsp");
	return mv;
}
}
