package com.spring.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.spring.Model.UserFriend2;



@Controller
public class MyFriendController  {
	
	
	@RequestMapping(value="myfriend")
	public  ModelAndView myfriend(String email,String user,Model model,HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException 
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
		int userid1=Integer.parseInt(user); 
		
		
		
	
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
			
	    
	        String queryString = "Select DISTINCT r.username,r.userid from registratiion1 r inner join friends f on r.userid=f.userid where f.friendid=(select r.userid from registratiion1 r where r.email=? and status='2') union  Select DISTINCT username,r.userid from registratiion1 r inner join friends f on r.userid=f.friendid where f.userid=(select r.userid from registratiion1 r where r.email=? and status='2'and status!='0')";
	        PreparedStatement ps=conn.prepareStatement(queryString);
	        ps.setString(1,email);
	        ps.setString(2,email);
	        
	        ResultSet result = ps.executeQuery();
	        
	        ArrayList<String> friendList = new ArrayList<String>();
	        ArrayList<UserFriend2> std = new ArrayList<UserFriend2>();
	        while(result.next()) {
	      
	        		String name=result.getString("username");
	        		int friend=result.getInt("userid");
	        		String userid=String.valueOf(friend);  
	        
	        		List<String> namesList = Arrays.asList( name,userid);
	        			friendList.addAll(namesList);   
	        		std.add(new UserFriend2(name,userid));
	        	  	 
	        	
	        	
	        
	        }
	        request.setAttribute("data", std);
	    	mv.addObject("friend_name",friendList);
    		mv.setViewName("myfriend.jsp");
    		 
	       

	        result.close();
	        ps.close();
	        conn.close();

	    } catch (SQLException sql) {

	    	
	    }
		
		
		return mv;
		
		
	

}
}
