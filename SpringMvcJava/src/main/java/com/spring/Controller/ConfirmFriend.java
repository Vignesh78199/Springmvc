package com.spring.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfirmFriend {
	
	
	@RequestMapping(value="/ConfirmFriend")
	@ResponseBody
	public void confirmFriend(String user,String friend, Model model,HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException 
	{
		
		
		Cookie[] cookies=request.getCookies();
		for(Cookie temp:cookies)
		{
			if("userid".equals(temp.getName()))
			{
				user=temp.getValue();
			}
		}
		int userid=Integer.parseInt(user);  
		friend =request.getParameter("userid");
		int friendid=Integer.parseInt(friend);
		System.out.println(userid+" "+friendid);
	

		 try {
		    	Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
				
		    
		        String queryString = "UPDATE friends SET status='2' WHERE (userid=? AND friendid=?) OR (friendid=? AND userid=?)";
		        PreparedStatement ps=conn.prepareStatement(queryString);
		        ps.setInt(1,userid);
		        ps.setInt(2,friendid);
		        ps.setInt(3,userid);
		        ps.setInt(4,friendid);
		        int result = ps.executeUpdate();
		       
		        ps.close();
		        conn.close();

		    } 
		 catch (SQLException sql) {

			 
		    }
		 
		
			
	
	}

}
