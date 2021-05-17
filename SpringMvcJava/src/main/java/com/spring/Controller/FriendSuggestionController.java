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


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Model.UserFriend;

@Controller
public class FriendSuggestionController {
	
	
	@RequestMapping("/suggest")
	public  ModelAndView FriendSuggestion(String email,String place,String username,String age1,HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException 
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
    		mv.setViewName("friendsuggestion.jsp");
	        result.close();
	        ps.close();
	        conn.close();

	    } catch (SQLException sql) {

	    
	    }
		
		mv.setViewName("friendsuggestion.jsp");
		return mv;
		
	}

}
